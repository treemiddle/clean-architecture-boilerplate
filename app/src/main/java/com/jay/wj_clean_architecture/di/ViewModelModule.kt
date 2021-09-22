package com.jay.wj_clean_architecture.di

import com.jay.wj_clean_architecture.ui.home.HomeViewModel
import org.koin.dsl.module

val viewModelModule = module {

    single { HomeViewModel(get()) }

}