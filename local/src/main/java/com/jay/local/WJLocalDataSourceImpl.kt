package com.jay.local

import com.jay.data.local.WJLocal
import com.jay.data.model.DataModel
import com.jay.local.dao.WJDao
import com.jay.local.mapper.WJLocalMapper
import com.jay.local.pref.PreferenceHelper
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class WJLocalDataSourceImpl(
    private val dao: WJDao,
    private val pref: PreferenceHelper
) : WJLocal {

    override fun getMovies(): Single<List<DataModel>> {
        return dao.getMovies()
            .map { it.map(WJLocalMapper::mapToData) }
            .subscribeOn(Schedulers.io())
    }

    override fun saveMovies(movies: List<DataModel>): Completable {
        return dao.deleteAll()
            .andThen(Single.just(movies))
            .map { it.map(WJLocalMapper::mapToLocal) }
            .flatMapCompletable(dao::insertMovies)
            .subscribeOn(Schedulers.io())
    }

}