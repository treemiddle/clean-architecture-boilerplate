package com.jay.domain.repository

import com.jay.domain.model.DomainModel
import io.reactivex.Flowable

interface WJRepository {

    fun getMovies(query: String): Flowable<List<DomainModel>>

}