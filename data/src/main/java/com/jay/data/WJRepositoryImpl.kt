package com.jay.data

import com.jay.data.local.WJLocal
import com.jay.data.mapper.WJDataMapper
import com.jay.data.model.DataModel
import com.jay.data.remote.WJRemote
import com.jay.domain.model.DomainModel
import com.jay.domain.repository.WJRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class WJRepositoryImpl(
    private val localDataSource: WJLocal,
    private val remoteDataSource: WJRemote
) : WJRepository {

    override fun clearAll(): Completable {
        return localDataSource.clearAll()
    }

    override fun getItems(): Flowable<List<DomainModel>> {
        return localDataSource.getItems()
            .onErrorReturn { listOf() }
            .flatMapPublisher { cachedItems ->
                if (cachedItems.isEmpty()) {
                    getRemoteItems()
                        .map { it.map(WJDataMapper::mapToModel) }
                        .toFlowable()
                        .onErrorReturn { listOf() }
                } else {
                    val local = Single.just(cachedItems)
                        .map { it.map(WJDataMapper::mapToModel) }
                    val remote = getRemoteItems()
                        .map { it.map(WJDataMapper::mapToModel) }
                        .onErrorResumeNext { local }

                    Single.concat(local, remote)
                }
            }
    }

    private fun getRemoteItems(): Single<List<DataModel>> {
        return remoteDataSource.getItems()
            .flatMap { remoteItems ->
                localDataSource.saveItems(remoteItems)
                    .andThen(Single.just(remoteItems))
            }
    }

}