package com.soutvoid.gamesproject.interactor.common.network.calladapter;

import com.agna.ferro.mvp.component.scope.PerApplication;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.soutvoid.gamesproject.app.log.Logger;
import com.soutvoid.gamesproject.interactor.common.network.error.CacheEmptyException;
import com.soutvoid.gamesproject.interactor.common.network.error.HttpCodes;
import com.soutvoid.gamesproject.interactor.common.network.error.HttpError;
import com.soutvoid.gamesproject.interactor.common.network.error.NoInternetException;
import com.soutvoid.gamesproject.interactor.common.network.response.BaseResponse;
import com.soutvoid.gamesproject.interactor.common.network.service.RequestBodyMap;
import com.soutvoid.gamesproject.interactor.common.network.service.RequestBodyTypeAdapter;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.HttpException;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;

/**
 * Created by andrew on 2/21/17.
 */

@PerApplication
public class CallAdapterFactory extends CallAdapter.Factory {

    private final Gson gson;
    private RxJavaCallAdapterFactory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();
    private CopyOnWriteArrayList<String> retryCalls = new CopyOnWriteArrayList<>();

    @Inject
    public CallAdapterFactory() {

        this.gson = new GsonBuilder()
                .registerTypeAdapter(RequestBodyMap.class, new RequestBodyTypeAdapter())
                .create();
    }

    @SuppressWarnings("unchecked")
    @Override
    public CallAdapter<?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        CallAdapter<Observable<?>> rxCallAdapter =
                (CallAdapter<Observable<?>>) rxJavaCallAdapterFactory.get(returnType, annotations, retrofit);
        return new ResultCallAdapter(rxCallAdapter, returnType);
    }

    private final class ResultCallAdapter implements CallAdapter<Observable<?>> {
        private final Type responseType;
        private final CallAdapter<Observable<?>> rxCallAdapter;

        public ResultCallAdapter(CallAdapter<Observable<?>> rxCallAdapter, Type returnType) {
            Type observableType = getParameterUpperBound(0, (ParameterizedType) returnType);
            this.rxCallAdapter = rxCallAdapter;
            this.responseType = observableType;
        }

        @Override
        public Type responseType() {
            return responseType;
        }

        @SuppressWarnings("unchecked")
        @Override
        public <R> Observable<R> adapt(Call<R> call) {
            Observable<R> observable = (Observable<R>) rxCallAdapter.adapt(call);
            return observable.onErrorResumeNext(e -> this.handleNetworkError(e, call));
        }

        private <R> Observable<R> handleNetworkError(Throwable e,
                                                     Call<R> call) {
            if (e instanceof IOException) {
                return Observable.error(new NoInternetException(e));
            } else if (e instanceof CacheEmptyException) {
                return Observable.just(null); //кеш пуст
            } else if (e instanceof HttpException) {
                HttpException httpException = (HttpException) e;
                BaseResponse errorResponse = parseErrorResponse(httpException);
                HttpError httpError = new HttpError(httpException.message(), httpException,
                        httpException.code(), errorResponse);
                int httpCode = httpError.getCode();

                if (httpCode == HttpCodes.CODE_304) {
                    return Observable.empty();
                } else {
                    return Observable.error(httpError);
                }
            } else {
                return Observable.error(e);
            }

        }

        private BaseResponse parseErrorResponse(HttpException httpException) {
            BaseResponse errorResponse = null;
            try {
                errorResponse = gson.fromJson(
                        httpException.response().errorBody().string(),
                        BaseResponse.class);
            } catch (IOException | JsonSyntaxException e) {
                Logger.w(e);
            }
            return errorResponse;
        }

    }

}
