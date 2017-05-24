package com.soutvoid.gamesproject.interactor.common.network.calladapter

import com.agna.ferro.mvp.component.scope.PerApplication
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import com.soutvoid.gamesproject.app.log.Logger
import com.soutvoid.gamesproject.interactor.common.network.error.CacheEmptyException
import com.soutvoid.gamesproject.interactor.common.network.error.HttpCodes
import com.soutvoid.gamesproject.interactor.common.network.error.HttpError
import com.soutvoid.gamesproject.interactor.common.network.error.NoInternetException
import com.soutvoid.gamesproject.interactor.common.network.response.BaseResponse
import com.soutvoid.gamesproject.interactor.common.network.service.RequestBodyMap
import com.soutvoid.gamesproject.interactor.common.network.service.RequestBodyTypeAdapter
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.HttpException
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import rx.Observable
import java.io.IOException
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.concurrent.CopyOnWriteArrayList
import javax.inject.Inject

/**
 * Created by andrew on 2/21/17.
 */

@PerApplication
class CallAdapterFactory @Inject
constructor() : CallAdapter.Factory() {

    private val gson: Gson
    private val rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create()
    private val retryCalls = CopyOnWriteArrayList<String>()

    init {

        this.gson = GsonBuilder()
                .registerTypeAdapter(RequestBodyMap::class.java, RequestBodyTypeAdapter())
                .create()
    }

    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*> {
        val rxCallAdapter = rxJavaCallAdapterFactory.get(returnType, annotations, retrofit) as CallAdapter<Observable<*>>
        return ResultCallAdapter(rxCallAdapter, returnType)
    }

    private inner class ResultCallAdapter(private val rxCallAdapter: CallAdapter<Observable<*>>, returnType: Type) : CallAdapter<Observable<*>> {
        private val responseType: Type

        init {
            val observableType = CallAdapter.Factory.getParameterUpperBound(0, returnType as ParameterizedType)
            this.responseType = observableType
        }

        override fun responseType(): Type {
            return responseType
        }

        override fun <R> adapt(call: Call<R>): Observable<R> {
            val observable = rxCallAdapter.adapt(call) as Observable<R>
            return observable.onErrorResumeNext { e -> this.handleNetworkError(e, call) }
        }

        private fun <R> handleNetworkError(e: Throwable,
                                           call: Call<R>): Observable<R> {
            if (e is IOException) {
                return Observable.error<R>(NoInternetException(e))
            } else if (e is CacheEmptyException) {
                return Observable.just<R>(null) //кеш пуст
            } else if (e is HttpException) {
                val httpException = e
                val errorResponse = parseErrorResponse(httpException)
                val httpError = HttpError(httpException.message(), httpException,
                        httpException.code(), errorResponse)
                val httpCode = httpError.code

                if (httpCode == HttpCodes.CODE_304) {
                    return Observable.empty<R>()
                } else {
                    return Observable.error<R>(httpError)
                }
            } else {
                return Observable.error<R>(e)
            }

        }

        private fun parseErrorResponse(httpException: HttpException): BaseResponse? {
            var errorResponse: BaseResponse? = null
            try {
                errorResponse = gson.fromJson(
                        httpException.response().errorBody().string(),
                        BaseResponse::class.java)
            } catch (e: IOException) {
                Logger.w(e)
            } catch (e: JsonSyntaxException) {
                Logger.w(e)
            }

            return errorResponse
        }

    }

}
