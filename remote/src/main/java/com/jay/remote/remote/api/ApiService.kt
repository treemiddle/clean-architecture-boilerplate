package com.jay.remote.remote.api

import com.jay.remote.remote.model.RemoteModel
import com.jay.remote.remote.model.RemoteResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v1/search/movie.json")
    fun getSearchMovie(
        @Query("query") query: String
    ): Single<RemoteResponse<RemoteModel>>

}