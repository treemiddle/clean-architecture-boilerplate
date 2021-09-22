package com.jay.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jay.local.constants.LocalConstants

@Entity(tableName = LocalConstants.TABLE_NAME)
data class LocalModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val link: String,
    val image: String,
    val subtitle: String,
    val pubDate: String,
    val director: String,
    val actor: String,
    val userRating: String
)
