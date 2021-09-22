package com.jay.local

import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jay.local.converter.WJTypeConverter
import com.jay.local.dao.WJDao

@TypeConverters(value = [WJTypeConverter::class])
abstract class WJDatabase : RoomDatabase() {
    abstract val dao: WJDao
}