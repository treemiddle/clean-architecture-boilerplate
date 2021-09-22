package com.jay.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jay.local.constants.LocalConstants
import com.jay.local.converter.WJTypeConverter
import com.jay.local.dao.WJDao
import com.jay.local.model.LocalModel

@TypeConverters(value = [WJTypeConverter::class])
@Database(entities = [LocalModel::class], exportSchema = false, version = 1)
abstract class WJDatabase : RoomDatabase() {
    abstract val dao: WJDao

    object Factory {
        fun create(applicationContext: Context): WJDatabase {
            return Room.databaseBuilder(
                applicationContext.applicationContext,
                WJDatabase::class.java,
                LocalConstants.DATABASE_NAME
            ).fallbackToDestructiveMigration().build()
        }
    }
}