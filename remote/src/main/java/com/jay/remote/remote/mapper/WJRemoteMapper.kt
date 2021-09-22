package com.jay.remote.remote.mapper

import com.jay.data.model.DataModel
import com.jay.remote.remote.model.RemoteModel
import com.jay.remote.remote.util.ext.toDateWith
import com.jay.remote.remote.util.ext.toPlanFromHtml
import java.util.*

object WJRemoteMapper : RemoteMapper<RemoteModel, DataModel> {
    private const val DATE_FORMAT_YEAR = "yyyy"

    override fun mapToData(from: RemoteModel): DataModel {
        return DataModel(
            title = from.title.toPlanFromHtml(),
            link = from.link,
            image = from.image,
            subtitle = from.subtitle.toPlanFromHtml(),
            pubDate = from.pubDate.toDateWith(DATE_FORMAT_YEAR) ?: Date(0),
            director = from.director.toPlanFromHtml(),
            actor = from.actor.toPlanFromHtml(),
            userRating = from.userRating.toFloatOrNull() ?: 0f
        )
    }

}