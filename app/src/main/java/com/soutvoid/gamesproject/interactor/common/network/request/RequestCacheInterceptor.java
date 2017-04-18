package com.soutvoid.gamesproject.interactor.common.network.request;

import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.interactor.network.connection.NetworkConnectionChecker;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@PerApplication
public class RequestCacheInterceptor implements Interceptor {

    NetworkConnectionChecker networkConnectionChecker;

    public RequestCacheInterceptor(NetworkConnectionChecker networkConnectionChecker) {
        this.networkConnectionChecker = networkConnectionChecker;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        if (!networkConnectionChecker.hasInternetConnection()) {
            CacheControl cacheControl = new CacheControl.Builder()
                    .maxStale(7, TimeUnit.DAYS)
                    .build();

            request = request.newBuilder()
                    .cacheControl(cacheControl)
                    .build();
        }

        return chain.proceed(request);
    }
}
