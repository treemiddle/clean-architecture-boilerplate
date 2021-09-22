package com.jay.remote.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class RemoteResponse<T>(
    @SerializedName("total")
    @Expose
    val total: Int,

    @SerializedName("start")
    @Expose
    val start: Int,

    @SerializedName("display")
    @Expose
    val display: Int,

    @SerializedName("lastBuildDate")
    @Expose
    val lastBuildDate: Date,

    @SerializedName("items")
    @Expose
    val items: List<T>
)