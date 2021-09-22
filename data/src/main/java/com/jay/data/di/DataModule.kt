package com.jay.data.di

import com.jay.data.WJRepositoryImpl
import com.jay.domain.repository.WJRepository
import org.koin.dsl.module

val dataModule = module {

    single<WJRepository> { WJRepositoryImpl(get(), get()) }

}