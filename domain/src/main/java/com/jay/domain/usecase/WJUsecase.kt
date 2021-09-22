package com.jay.domain.usecase

import com.jay.domain.model.DomainModel
import com.jay.domain.repository.WJRepository
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

interface WJUsecase {

    fun getSearchMovie(query: String): Flowable<List<DomainModel>>

}

class WJUsecaseImpl(
    private val repository: WJRepository
) : WJUsecase {

    override fun getSearchMovie(query: String): Flowable<List<DomainModel>> {
        return repository.getMovies(query)
    }
}