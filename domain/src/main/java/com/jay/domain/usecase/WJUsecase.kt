package com.jay.domain.usecase

import com.jay.domain.model.DomainModel
import com.jay.domain.repository.WJRepository
import io.reactivex.Flowable

class WJUsecase(
    private val repository: WJRepository
) {

    fun getSearchMovie(query: String): Flowable<List<DomainModel>> {
        return repository.getMovies(query)
    }

}