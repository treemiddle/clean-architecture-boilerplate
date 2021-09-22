package com.jay.remote.remote.model

import java.util.*

data class RemoteResponse<T>(
    val total: Int,
    val start: Int,
    val display: Int,
    val lastBuildDate: Date,
    val items: List<T>
)