package com.jay.wj_clean_architecture

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WJApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}