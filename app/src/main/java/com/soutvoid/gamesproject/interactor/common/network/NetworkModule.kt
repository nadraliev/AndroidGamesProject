package com.soutvoid.gamesproject.interactor.common.network

import com.agna.ferro.mvp.component.scope.PerApplication
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.soutvoid.gamesproject.interactor.common.network.calladapter.CallAdapterFactory
import com.soutvoid.gamesproject.interactor.common.network.parse.BooleanAdapter
import com.soutvoid.gamesproject.interactor.common.network.parse.IntAdapter
import com.soutvoid.gamesproject.interactor.common.network.parse.ResponseTypeAdapterFactory
import com.soutvoid.gamesproject.interactor.common.network.parse.StringAdapter
import com.soutvoid.gamesproject.interactor.common.network.request.RequestCacheInterceptor
import com.soutvoid.gamesproject.interactor.common.network.request.RequestHeadersInterceptor
import com.soutvoid.gamesproject.interactor.common.network.response.ResponseCacheInterceptor
import com.soutvoid.gamesproject.interactor.network.connection.NetworkConnectionChecker

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import soutvoid.com.gamesproject.BuildConfig
import timber.log.Timber


@Module
class NetworkModule {

    @Provides
    @PerApplication
    internal fun provideRetrofit(okHttpClient: OkHttpClient,
                                 callAdapterFactory: CallAdapterFactory,
                                 gson: Gson): Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(ServerUrls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(callAdapterFactory)
                .build()
    }

    @Provides
    @PerApplication
    internal fun provideGson(responseTypeAdapterFactory: ResponseTypeAdapterFactory): Gson {
        return GsonBuilder()
                .registerTypeAdapterFactory(responseTypeAdapterFactory)
                .registerTypeAdapter(Boolean::class.java, BooleanAdapter())
                .registerTypeAdapter(Boolean::class.javaPrimitiveType, BooleanAdapter())
                .registerTypeAdapter(String::class.java, StringAdapter())
                .registerTypeAdapter(Int::class.java, IntAdapter())
                .registerTypeAdapter(Int::class.javaPrimitiveType, IntAdapter())
                .create()
    }

    @Provides
    @PerApplication
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor { message -> Timber.tag(HTTP_LOG_TAG).d(message) }
        if (BuildConfig.DEBUG) {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        }
        return loggingInterceptor
    }

    @Provides
    @PerApplication
    internal fun provideRequestHeadersInterceptor(): RequestHeadersInterceptor {
        return RequestHeadersInterceptor()
    }

    @Provides
    @PerApplication
    internal fun provideResponseCacheInterceptor(): ResponseCacheInterceptor {
        return ResponseCacheInterceptor()
    }

    @Provides
    @PerApplication
    internal fun provideRequestCacheInterceptor(networkConnectionChecker: NetworkConnectionChecker): RequestCacheInterceptor {
        return RequestCacheInterceptor(networkConnectionChecker)
    }

    companion object {

        val HTTP_LOG_TAG = "OkHttp"
    }

}
