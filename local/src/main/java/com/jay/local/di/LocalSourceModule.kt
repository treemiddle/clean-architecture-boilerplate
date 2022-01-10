package com.jay.local.di

import com.jay.data.local.WJLocal
import com.jay.local.WJLocalDataSourceImpl
import com.jay.local.dao.WJDao
import com.jay.local.pref.PreferenceHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalSourceModule {

    @Provides
    @Singleton
    fun provideLocalSource(
        dao: WJDao,
        prefs: PreferenceHelper
    ): WJLocal {
        return WJLocalDataSourceImpl(dao, prefs)
    }

}