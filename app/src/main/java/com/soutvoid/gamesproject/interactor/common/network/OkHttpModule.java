package com.soutvoid.gamesproject.interactor.common.network;

import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.interactor.common.network.request.RequestCacheInterceptor;
import com.soutvoid.gamesproject.interactor.common.network.request.RequestHeadersInterceptor;
import com.soutvoid.gamesproject.interactor.common.network.response.ResponseCacheInterceptor;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;


@Module
public class OkHttpModule {

    public static final int NETWORK_TIMEOUT = 10; //seconds

    @Provides
    @PerApplication
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor,
                                     RequestHeadersInterceptor requestHeadersInterceptor,
                                     ResponseCacheInterceptor responseCacheInterceptor,
                                     RequestCacheInterceptor requestCacheInterceptor,
                                     Cache cache) {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS);
        okHttpClientBuilder.writeTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS);

        okHttpClientBuilder.addInterceptor(requestHeadersInterceptor);
        okHttpClientBuilder.addInterceptor(httpLoggingInterceptor);
        okHttpClientBuilder.addInterceptor(requestCacheInterceptor);
        okHttpClientBuilder.addNetworkInterceptor(responseCacheInterceptor);
        okHttpClientBuilder.cache(cache);
        return okHttpClientBuilder.build();
    }

}
