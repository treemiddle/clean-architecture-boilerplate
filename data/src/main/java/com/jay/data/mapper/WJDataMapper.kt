package com.jay.data.mapper

import com.jay.data.model.DataModel
import com.jay.domain.model.DomainModel

object WJDataMapper : DataMapper<DataModel, DomainModel> {

    override fun mapToModel(from: DataModel): DomainModel {
        return DomainModel(
            id = from.id,
            name = from.name,
            title = from.title,
            avatar = from.avatar
        )
    }

}