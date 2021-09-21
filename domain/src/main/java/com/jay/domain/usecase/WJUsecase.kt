package com.jay.domain.usecase

import com.jay.domain.model.DomainModel
import com.jay.domain.repository.WJRepository
import io.reactivex.Flowable

interface WJUsecase {

    fun getItems(): Flowable<List<DomainModel>>

}

class WJUsecaseImpl(
    private val repository: WJRepository
) : WJUsecase {

    override fun getItems(): Flowable<List<DomainModel>> {
        return repository.getItems()
    }

}