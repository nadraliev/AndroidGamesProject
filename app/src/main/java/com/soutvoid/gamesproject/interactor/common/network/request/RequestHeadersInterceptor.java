package com.soutvoid.gamesproject.interactor.common.network.request;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static com.soutvoid.gamesproject.interactor.common.network.ServerConstants.API_KEY;
import static com.soutvoid.gamesproject.interactor.common.network.ServerConstants.KEY_API_KEY;


/**
 * Created by andrew on 2/23/17.
 */

public class RequestHeadersInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder().addHeader(KEY_API_KEY, API_KEY).build();
        return chain.proceed(request);
    }
}
