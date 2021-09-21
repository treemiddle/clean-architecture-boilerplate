package com.jay.data.di

import com.jay.data.WJRepositoryImpl
import com.jay.data.local.WJLocal
import com.jay.data.remote.WJRemote
import com.jay.domain.repository.WJRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DataServiceFactory {

    @Provides
    @Singleton
    fun provideRepository(
        localDataSource: WJLocal,
        remoteDataSource: WJRemote
    ): WJRepository {
        return WJRepositoryImpl(localDataSource, remoteDataSource)
    }

}