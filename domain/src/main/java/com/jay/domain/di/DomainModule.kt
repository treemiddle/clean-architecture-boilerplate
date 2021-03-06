package com.jay.domain.di

import com.jay.domain.repository.WJRepository
import com.jay.domain.usecase.WJUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideWJUsecase(repository: WJRepository): WJUsecase {
        return WJUsecase(repository)
    }

}