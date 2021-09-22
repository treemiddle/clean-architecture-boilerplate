package com.jay.wj_clean_architecture

import android.app.Application
import com.jay.data.local.WJLocal
import com.jay.data.remote.WJRemote
import com.jay.domain.repository.WJRepository
import com.jay.domain.usecase.WJUsecase
import com.jay.local.WJDatabase
import com.jay.local.dao.WJDao
import com.jay.remote.remote.api.ApiService
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WJApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}