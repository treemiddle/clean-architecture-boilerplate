package com.jay.local.mapper

import com.jay.data.model.DataModel
import com.jay.local.model.LocalModel

object WJLocalMapper : LocalMapper<LocalModel, DataModel> {

    override fun mapToLocal(from: DataModel): LocalModel {
        return LocalModel(
            id = 0L,
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

    override fun mapToData(from: LocalModel): DataModel {
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