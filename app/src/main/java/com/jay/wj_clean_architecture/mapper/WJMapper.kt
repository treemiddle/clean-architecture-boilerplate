package com.jay.wj_clean_architecture.mapper

import com.jay.domain.model.DomainModel
import com.jay.wj_clean_architecture.model.WJViewModel

object WJMapper : Mapper<WJViewModel, DomainModel> {

    override fun mapToView(from: DomainModel): WJViewModel {
        return WJViewModel(
            name = from.name,
            title = from.title,
            avatar = from.avatar
        )
    }
}