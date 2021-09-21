package com.jay.data.local

import com.jay.data.model.DataModel
import io.reactivex.Completable
import io.reactivex.Single

interface WJLocal {

    var lastLocalTime: Long

    fun clearAll(): Completable

    fun saveItems(items: List<DataModel>): Completable

    fun getItems(): Single<List<DataModel>>

}