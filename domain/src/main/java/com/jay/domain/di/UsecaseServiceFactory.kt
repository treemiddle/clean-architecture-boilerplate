//package com.jay.domain.di
//
//import com.jay.domain.repository.WJRepository
//import com.jay.domain.usecase.WJUsecase
//import com.jay.domain.usecase.WJUsecaseImpl
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//object UsecaseServiceFactory {
//
//    @Provides
//    @Singleton
//    fun provideUsecase(
//        repository: WJRepository
//    ): WJUsecase {
//        return WJUsecaseImpl(repository)
//    }
//}