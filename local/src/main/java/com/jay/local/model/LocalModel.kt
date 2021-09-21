package com.jay.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jay.local.constants.LocalConstants

@Entity(tableName = LocalConstants.TABLE_NAME)
data class LocalModel(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    val name: String,
    val title: String,
    val avatar: String
)
