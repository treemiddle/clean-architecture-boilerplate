package com.jay.data.remote

import com.jay.data.model.DataModel
import io.reactivex.Single

interface WJRemote {

    fun getSearchMovie(query: String): Single<List<DataModel>>

}