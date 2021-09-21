package com.jay.local.mapper

import com.jay.data.model.DataModel
import com.jay.local.model.LocalModel

object WJLocalMapper : LocalMapper<LocalModel, DataModel> {

    override fun mapToLocal(from: DataModel): LocalModel {
        return LocalModel(
            id = from.id,
            name = from.name,
            title = from.title,
            avatar = from.avatar
        )
    }

    override fun mapToData(from: LocalModel): DataModel {
        return DataModel(
            id = from.id,
            name = from.name,
            title = from.title,
            avatar = from.avatar
        )
    }

}