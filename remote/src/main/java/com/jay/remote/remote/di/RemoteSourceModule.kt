package com.jay.remote.remote.di

import com.jay.data.remote.WJRemote
import com.jay.remote.remote.WJRemoteDataSourceImpl
import com.jay.remote.remote.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteSourceModule {

    @Provides
    @Singleton
    fun provideRemoteSource(): WJRemote {
        return WJRemoteDataSourceImpl()
    }

}