package com.jay.data.local

import com.jay.data.model.DataModel
import io.reactivex.Completable
import io.reactivex.Single

interface WJLocal {

    fun getMovies(): Single<List<DataModel>>

    fun saveMovies(movies: List<DataModel>): Completable

}