package com.jay.remote.remote

import com.jay.data.model.DataModel
import com.jay.data.remote.WJRemote
import com.jay.remote.remote.api.ApiService
import com.jay.remote.remote.mapper.WJRemoteMapper
import io.reactivex.Single
import java.util.*
import javax.inject.Inject

//private val service: ApiService
class WJRemoteDataSourceImpl @Inject constructor() : WJRemote {

    override fun getSearchMovie(query: String): Single<List<DataModel>> {
//        return service.getSearchMovie(query)
//            .map { it.items.map(WJRemoteMapper::mapToData) }
        return Single.just(
            listOf(
                DataModel(
                    "1",
                    "3",
                    "",
                    "",
                    Date(),
                    "",
                    "",
                    5f,
                )
            )
        )
    }

}