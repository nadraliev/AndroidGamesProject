package com.soutvoid.gamesproject.interactor.common.network;

import com.agna.ferro.mvp.component.scope.PerApplication;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.soutvoid.gamesproject.interactor.common.network.calladapter.CallAdapterFactory;
import com.soutvoid.gamesproject.interactor.common.network.parse.BooleanAdapter;
import com.soutvoid.gamesproject.interactor.common.network.parse.IntAdapter;
import com.soutvoid.gamesproject.interactor.common.network.parse.ResponseTypeAdapterFactory;
import com.soutvoid.gamesproject.interactor.common.network.parse.StringAdapter;
import com.soutvoid.gamesproject.interactor.common.network.request.RequestCacheInterceptor;
import com.soutvoid.gamesproject.interactor.common.network.request.RequestHeadersInterceptor;
import com.soutvoid.gamesproject.interactor.common.network.response.ResponseCacheInterceptor;
import com.soutvoid.gamesproject.interactor.network.connection.NetworkConnectionChecker;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import soutvoid.com.gamesproject.BuildConfig;
import timber.log.Timber;


@Module
public class NetworkModule {

    public static final String HTTP_LOG_TAG = "OkHttp";

    @Provides
    @PerApplication
    Retrofit provideRetrofit(OkHttpClient okHttpClient,
                             CallAdapterFactory callAdapterFactory,
                             Gson gson) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(ServerUrls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(callAdapterFactory)
                .build();
    }

    @Provides
    @PerApplication
    Gson provideGson(ResponseTypeAdapterFactory responseTypeAdapterFactory) {
        return new GsonBuilder()
                .registerTypeAdapterFactory(responseTypeAdapterFactory)
                .registerTypeAdapter(Boolean.class, new BooleanAdapter())
                .registerTypeAdapter(boolean.class, new BooleanAdapter())
                .registerTypeAdapter(String.class, new StringAdapter())
                .registerTypeAdapter(Integer.class, new IntAdapter())
                .registerTypeAdapter(int.class, new IntAdapter())
                .create();
    }

    @Provides
    @PerApplication
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(message -> Timber.tag(HTTP_LOG_TAG).d(message));
        if (BuildConfig.DEBUG) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }
        return loggingInterceptor;
    }

    @Provides
    @PerApplication
    RequestHeadersInterceptor provideRequestHeadersInterceptor() {
        return new RequestHeadersInterceptor();
    }

    @Provides
    @PerApplication
    ResponseCacheInterceptor provideResponseCacheInterceptor() {
        return new ResponseCacheInterceptor();
    }

    @Provides
    @PerApplication
    RequestCacheInterceptor provideRequestCacheInterceptor(NetworkConnectionChecker networkConnectionChecker) {
        return new RequestCacheInterceptor(networkConnectionChecker);
    }

}
