package com.jay.domain.repository

import com.jay.domain.model.DomainModel
import io.reactivex.Completable
import io.reactivex.Flowable

interface WJRepository {

    fun clearAll(): Completable

    fun getItems(): Flowable<List<DomainModel>>

}