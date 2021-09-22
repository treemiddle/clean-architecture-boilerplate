package com.jay.wj_clean_architecture

import android.app.Application
import com.jay.data.di.dataModule
import com.jay.domain.di.domainModule
import com.jay.local.di.localModule
import com.jay.remote.remote.di.remoteModule
import com.jay.wj_clean_architecture.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class WJApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.DEBUG else Level.NONE)
            androidContext(this@WJApplication)
            modules(
                remoteModule,
                localModule,
                dataModule,
                domainModule,
                viewModelModule
            )
        }
    }

}