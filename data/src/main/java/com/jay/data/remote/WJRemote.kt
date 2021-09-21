package com.jay.data.remote

import com.jay.data.model.DataModel
import io.reactivex.Single

interface WJRemote {

    fun getItems(): Single<List<DataModel>>

}