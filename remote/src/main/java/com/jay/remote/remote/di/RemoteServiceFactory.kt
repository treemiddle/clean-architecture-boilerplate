//package com.jay.remote.remote.di
//
//import com.google.gson.FieldNamingPolicy
//import com.google.gson.Gson
//import com.google.gson.GsonBuilder
//import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
//import com.jay.remote.BuildConfig
//import com.jay.remote.remote.api.ApiService
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.components.ApplicationComponent
//import io.reactivex.schedulers.Schedulers
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import java.util.concurrent.TimeUnit
//import javax.inject.Singleton
//
//@Module
//@InstallIn(ApplicationComponent::class)
//object RemoteServiceFactory {
//
//    @Provides
//    @Singleton
//    fun createService(): ApiService {
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BuildConfig.BASE_URL)
//            .client(createOkhttpClient())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
//            .addConverterFactory(GsonConverterFactory.create(createGson()))
//            .build()
//
//        return retrofit.create(ApiService::class.java)
//    }
//
//    @Provides
//    @Singleton
//    fun createGson(): Gson {
//        return GsonBuilder()
//            .setLenient()
//            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
//            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//            .create()
//    }
//
//    @Provides
//    @Singleton
//    fun createLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
//        level = if (BuildConfig.DEBUG) {
//            HttpLoggingInterceptor.Level.BODY
//        } else {
//            HttpLoggingInterceptor.Level.NONE
//        }
//    }
//
//    @Provides
//    @Singleton
//    fun createOkhttpClient(): OkHttpClient {
//        return OkHttpClient.Builder()
//            .connectTimeout(60, TimeUnit.SECONDS)
//            .addInterceptor(createLoggingInterceptor())
//            .readTimeout(60, TimeUnit.SECONDS)
//            .build()
//    }
//
//}