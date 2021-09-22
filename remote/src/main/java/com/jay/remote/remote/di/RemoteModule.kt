package com.jay.remote.remote.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.jay.data.remote.WJRemote
import com.jay.remote.BuildConfig
import com.jay.remote.remote.WJRemoteDataSourceImpl
import com.jay.remote.remote.api.ApiService
import com.jay.remote.remote.interceptor.WJInterceptor
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val GSON_DATE_FORMAT = "E, dd MMM yyyy HH:mm:ss Z"

val remoteModule = module {

    single { WJInterceptor() }

    single {
        GsonBuilder()
            .setLenient()
            .setDateFormat(GSON_DATE_FORMAT)
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
    }

    single {
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    single {
        OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(get<WJInterceptor>())
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single {
        RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
    }

    single {
        GsonConverterFactory.create(get())
    }

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.NAVER_BASE_URL)
            .client(get())
            .addCallAdapterFactory(get<RxJava2CallAdapterFactory>())
            .addConverterFactory(get<GsonConverterFactory>())
            .build()
    }

    single { get<Retrofit>().create(ApiService::class.java) }

    single<WJRemote> { WJRemoteDataSourceImpl(get()) }

}