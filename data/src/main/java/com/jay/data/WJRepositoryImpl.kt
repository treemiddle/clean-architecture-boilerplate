package com.jay.data

import com.jay.data.local.WJLocal
import com.jay.data.mapper.WJDataMapper
import com.jay.data.model.DataModel
import com.jay.data.remote.WJRemote
import com.jay.domain.model.DomainModel
import com.jay.domain.repository.WJRepository
import io.reactivex.Flowable
import io.reactivex.Single

class WJRepositoryImpl(
    private val localDataSource: WJLocal,
    private val remoteDataSource: WJRemote
) : WJRepository {

    override fun getMovies(query: String): Flowable<List<DomainModel>> {
        return localDataSource.getMovies()
            .onErrorReturn { listOf() }
            .flatMapPublisher { cachedItems ->
                if (cachedItems.isEmpty()) {
                    getRemoteItems(query)
                        .map { it.map(WJDataMapper::mapToModel) }
                        .toFlowable()
                        .onErrorReturn { listOf() }
                } else {
                    val local = Single.just(cachedItems)
                        .map { it.map(WJDataMapper::mapToModel) }
                    val remote = getRemoteItems(query)
                        .map { it.map(WJDataMapper::mapToModel) }
                        .onErrorResumeNext { local }

                    Single.concat(local, remote)
                }
            }
    }

    private fun getRemoteItems(query: String): Single<List<DataModel>> {
        return remoteDataSource.getSearchMovie(query)
            .flatMap { remoteItems ->
                localDataSource.saveMovies(remoteItems)
                    .andThen(Single.just(remoteItems))
            }
    }

}