package com.jay.wj_clean_architecture.mapper

import com.jay.domain.model.DomainModel
import com.jay.remote.remote.util.ext.formatWith
import com.jay.wj_clean_architecture.model.WJViewModel

object WJMapper : Mapper<WJViewModel, DomainModel> {
    private const val DATE_FORMAT_YEAR = "yyyy"

    override fun mapToView(from: DomainModel): WJViewModel {
        return WJViewModel(
            title = from.title,
            link = from.link,
            image = from.image,
            subtitle = from.subtitle,
            pubDate = from.pubDate.formatWith(DATE_FORMAT_YEAR),
            director = from.director,
            actor = from.actor,
            userRating = from.userRating
        )
    }

}