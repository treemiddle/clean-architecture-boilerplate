package com.jay.local.converter

import androidx.room.TypeConverter
import java.util.*

internal object WJTypeConverter {

    @TypeConverter
    @JvmStatic
    fun fromDate(date: Date): Long {
        return date.time
    }

    @TypeConverter
    @JvmStatic
    fun toDate(time: Long): Date {
        return Date(time)
    }

}