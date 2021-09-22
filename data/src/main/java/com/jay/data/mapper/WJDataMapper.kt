package com.jay.data.mapper

import com.jay.data.model.DataModel
import com.jay.domain.model.DomainModel

object WJDataMapper : DataMapper<DataModel, DomainModel> {

    override fun mapToModel(from: DataModel): DomainModel {
        return DomainModel(
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