package com.jay.local.di

import android.content.Context
import androidx.room.Room
import com.jay.local.WJDatabase
import com.jay.local.constants.LocalConstants
import com.jay.local.dao.WJDao
import com.jay.local.pref.PreferenceHelper
import com.jay.local.pref.PreferenceHelperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun providePreferenceHelper(
        @ApplicationContext applicationContext: Context
    ): PreferenceHelper {
        return PreferenceHelperImpl(applicationContext)
    }

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext applicationContext: Context
    ): WJDatabase {
        return Room.databaseBuilder(
            applicationContext,
            WJDatabase::class.java, LocalConstants.DATABASE_NAME
        )
            .build()
    }

    @Provides
    fun provideWJDao(database: WJDatabase): WJDao {
        return database.wjDao()
    }

}