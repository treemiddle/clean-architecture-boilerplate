package com.jay.domain.usecase

import com.jay.domain.model.DomainModel
import com.jay.domain.repository.WJRepository
import io.reactivex.Flowable
import javax.inject.Inject

class WJUsecase @Inject constructor(private val repository: WJRepository) {

    fun getSearchMovie(query: String): Flowable<List<DomainModel>> {
        return repository.getMovies(query)
    }

}