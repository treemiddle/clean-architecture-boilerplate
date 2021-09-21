package com.jay.local

import androidx.room.RoomDatabase
import com.jay.local.dao.WJDao

abstract class WJDatabase : RoomDatabase() {
    abstract val dao: WJDao
}