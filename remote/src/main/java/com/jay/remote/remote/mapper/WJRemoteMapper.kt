package com.jay.remote.remote.mapper

import com.jay.data.model.DataModel
import com.jay.remote.remote.model.RemoteModel

object WJRemoteMapper : RemoteMapper<RemoteModel, DataModel> {

    override fun mapToRemote(from: RemoteModel): DataModel {
        return DataModel(
            title = from.title,
            link = from.link,
            image = from.image,
            subtitle = from.subtitle,
            pubDate = from.pubDate,
            director = from.director,
            actor = from.actor,
            userRating = from.userRating
        )
    }

}