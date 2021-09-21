package com.jay.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jay.local.constants.LocalConstants
import com.jay.local.model.LocalModel
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface WJDao {

    @Query(LocalConstants.SELECT_QUERY)
    fun getItems(): Single<List<LocalModel>>

    @Query(LocalConstants.DELETE_ALL)
    fun clearAll(): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveItems(items: List<LocalModel>): Completable

}