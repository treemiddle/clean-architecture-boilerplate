package com.jay.remote.remote.mapper

import com.jay.data.model.DataModel
import com.jay.remote.remote.model.RemoteModel

object WJRemoteMapper : RemoteMapper<RemoteModel, DataModel> {

    override fun mapToRemote(from: RemoteModel): DataModel {
        return DataModel(
            id = from.id,
            name = from.name,
            title = from.title,
            avatar = from.avatar
        )
    }

}