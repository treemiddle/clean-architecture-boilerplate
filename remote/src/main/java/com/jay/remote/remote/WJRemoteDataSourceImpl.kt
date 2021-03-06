package com.jay.remote.remote

import com.jay.data.model.DataModel
import com.jay.data.remote.WJRemote
import com.jay.remote.remote.api.ApiService
import com.jay.remote.remote.mapper.WJRemoteMapper
import io.reactivex.Single
import javax.inject.Inject


class WJRemoteDataSourceImpl @Inject constructor(private val service: ApiService) : WJRemote {

    override fun getSearchMovie(query: String): Single<List<DataModel>> {
        return service.getSearchMovie(query)
            .map { it.items.map(WJRemoteMapper::mapToData) }
    }

}