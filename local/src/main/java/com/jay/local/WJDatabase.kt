package com.jay.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jay.local.converter.WJTypeConverter
import com.jay.local.dao.WJDao
import com.jay.local.model.LocalModel

@TypeConverters(value = [WJTypeConverter::class])
@Database(entities = [LocalModel::class], exportSchema = false, version = 1)
abstract class WJDatabase : RoomDatabase() {
    abstract fun wjDao(): WJDao
}