import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.jay.remote.BuildConfig
import com.jay.remote.remote.interceptor.WJInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    //private const val GSON_DATE_FORMAT = "E, dd MMM yyyy HH:mm:ss Z"


//    @Provides
//    @Singleton
//    fun provideRetrofit(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(BuildConfig.NAVER_BASE_URL)
//            //.client(provideOkhttp())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideWJInterceptor(): WJInterceptor {
//        return WJInterceptor()
//    }

//    @Provides
//    @Singleton
//    fun provideGson(): Gson {
//        return GsonBuilder()
//            .setLenient()
//            //.setDateFormat(GSON_DATE_FORMAT)
//            //.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//            .create()
//    }
//
//    @Provides
//    @Singleton
//    fun provideHttpLogging(): HttpLoggingInterceptor {
//        return HttpLoggingInterceptor().apply {
//            level = if (BuildConfig.DEBUG) {
//                HttpLoggingInterceptor.Level.BODY
//            } else {
//                HttpLoggingInterceptor.Level.NONE
//            }
//        }
//    }
//
//    @Provides
//    @Singleton
//    fun provideOkhttp(): OkHttpClient {
//        return OkHttpClient.Builder()
//            .connectTimeout(3, TimeUnit.SECONDS)
//            .readTimeout(3, TimeUnit.SECONDS)
//            .addInterceptor(provideWJInterceptor())
//            .addInterceptor(provideHttpLogging())
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideRxJavaAdapter(): RxJava2CallAdapterFactory {
//        return RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
//    }

//    @Provides
//    @Singleton
//    fun provideGsonConverterFactory(): GsonConverterFactory {
//        return GsonConverterFactory.create(provideGson())
//    }

}