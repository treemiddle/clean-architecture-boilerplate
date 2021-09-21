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

    override var lastLocalTime: Long
        get() = pref.lastLocalTime
        set(value) {
            pref.lastLocalTime = value
        }

    override fun clearAll(): Completable {
        return dao.clearAll()
    }

    override fun saveItems(items: List<DataModel>): Completable {
        return dao.clearAll()
            .andThen(Single.just(items))
            .map { it.map(WJLocalMapper::mapToLocal) }
            .flatMapCompletable(dao::saveItems)
            .subscribeOn(Schedulers.io())
    }

    override fun getItems(): Single<List<DataModel>> {
        return dao.getItems()
            .map { it.map(WJLocalMapper::mapToData) }
            .subscribeOn(Schedulers.io())
    }

}