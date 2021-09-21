package com.jay.local.di

import android.content.Context
import androidx.room.Room
import com.jay.data.local.WJLocal
import com.jay.local.WJDatabase
import com.jay.local.WJLocalDataSourceImpl
import com.jay.local.constants.LocalConstants
import com.jay.local.dao.WJDao
import com.jay.local.pref.PreferenceHelper
import com.jay.local.pref.PreferenceHelperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalServiceFactory {

    @Provides
    @Singleton
    fun provideDao(database: WJDatabase): WJDao {
        return database.dao
    }

    @Provides
    @Singleton
    fun provideDatabase(applicationContext: Context): WJDatabase {
        return Room.databaseBuilder(
            applicationContext.applicationContext,
            WJDatabase::class.java,
            LocalConstants.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideSharedPrefs(applicationContext: Context): PreferenceHelper {
        return PreferenceHelperImpl(applicationContext)
    }

    @Provides
    @Singleton
    fun provideLocalSource(
        dao: WJDao,
        prefs: PreferenceHelper
    ): WJLocal {
        return WJLocalDataSourceImpl(dao, prefs)
    }

}