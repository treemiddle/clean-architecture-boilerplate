package com.jay.domain.di

import com.jay.domain.usecase.WJUsecase
import org.koin.dsl.module

val domainModule = module {

    single { WJUsecase(get()) }

}