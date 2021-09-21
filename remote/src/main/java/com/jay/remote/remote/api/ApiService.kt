package com.jay.remote.remote.api

import com.jay.remote.remote.model.RemoteModel
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("team.json")
    fun getItems(): Single<List<RemoteModel>>

}