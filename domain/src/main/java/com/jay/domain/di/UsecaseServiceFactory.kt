//package com.jay.domain.di
//
//import com.jay.domain.repository.WJRepository
//import com.jay.domain.usecase.WJUsecase
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.components.ActivityRetainedComponent
//import dagger.hilt.android.scopes.ActivityRetainedScoped
//
//@Module
//@InstallIn(ActivityRetainedComponent::class)
//object UsecaseServiceFactory {
//
//    @Provides
//    @ActivityRetainedScoped
//    fun provideUsecase(
//        repository: WJRepository
//    ): WJUsecase {
//        return WJUsecase(repository)
//    }
//
//}