package com.jay.local.di

import com.jay.data.local.WJLocal
import com.jay.local.WJDatabase
import com.jay.local.WJLocalDataSourceImpl
import com.jay.local.pref.PreferenceHelper
import com.jay.local.pref.PreferenceHelperImpl
import org.koin.dsl.module

val localModule = module {

    single { WJDatabase.Factory.create(get()) }

    single { get<WJDatabase>().dao }

    single<PreferenceHelper> { PreferenceHelperImpl(get()) }

    single<WJLocal> { WJLocalDataSourceImpl(get(), get()) }

}