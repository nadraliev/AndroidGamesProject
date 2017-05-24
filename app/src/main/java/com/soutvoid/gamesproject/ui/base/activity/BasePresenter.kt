package com.soutvoid.gamesproject.ui.base.activity

import com.agna.ferro.mvp.view.BaseView
import com.agna.ferro.mvprx.MvpRxPresenter
import com.soutvoid.gamesproject.ui.common.error.ErrorHandler

import rx.Observable
import rx.Subscriber
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.functions.Func2
import rx.schedulers.Schedulers

/**
 * Created by andrew on 2/25/17.
 */

open class BasePresenter<V : BaseView>(private val errorHandler: ErrorHandler) : MvpRxPresenter<V>() {

    override fun <T> subscribe(observable: Observable<T>,
                               onNext: Action1<T>,
                               onError: Action1<Throwable>): Subscription {
        var observable = observable
        observable = observable.observeOn(AndroidSchedulers.mainThread(), true)
        return super.subscribe(observable, onNext, onError)
    }

    override fun <T> subscribe(observable: Observable<T>,
                               replaceFrozenEventPredicate: Func2<T, T, Boolean>,
                               onNext: Action1<T>,
                               onError: Action1<Throwable>): Subscription {
        var observable = observable
        observable = observable.observeOn(AndroidSchedulers.mainThread(), true)
        return super.subscribe(observable, replaceFrozenEventPredicate, onNext, onError)
    }

    override fun <T> subscribe(observable: Observable<T>,
                               replaceFrozenEventPredicate: Func2<T, T, Boolean>,
                               subscriber: Subscriber<T>): Subscription {
        var observable = observable
        observable = observable.observeOn(AndroidSchedulers.mainThread(), true)
        return super.subscribe(observable, replaceFrozenEventPredicate, subscriber)
    }

    override fun <T> subscribe(observable: Observable<T>,
                               subscriber: Subscriber<T>): Subscription {
        var observable = observable
        observable = observable.observeOn(AndroidSchedulers.mainThread(), true)
        return super.subscribe(observable, subscriber)
    }

    override fun <T> subscribeWithoutFreezing(observable: Observable<T>,
                                              onNext: Action1<T>,
                                              onError: Action1<Throwable>): Subscription {
        return super.subscribeWithoutFreezing(observable, onNext, onError)
    }

    override fun <T> subscribeWithoutFreezing(observable: Observable<T>,
                                              subscriber: Subscriber<T>): Subscription {
        var observable = observable
        observable = observable.observeOn(AndroidSchedulers.mainThread(), true)
        return super.subscribeWithoutFreezing(observable, subscriber)
    }

    /**
     * Работает также как [.subscribe], кроме того предоставляет стандартную обработку
     * ошибок сетевых запросов
     */
    protected fun <T> subscribeNetworkQuery(observable: Observable<T>,
                                            onNext: Action1<T>,
                                            onError: Action1<Throwable>): Subscription {
        return subscribeNetworkQuery(observable, onNext, onError, errorHandler)
    }

    /**
     * Работает также как [.subscribe], кроме того предоставляет стандартную обработку
     * ошибок сетевых запросов
     */
    protected fun <T> subscribeNetworkQuery(observable: Observable<T>,
                                            onNext: Action1<T>): Subscription {
        return subscribeNetworkQuery(observable, onNext, null, errorHandler)
    }

    /**
     * Работает также как [.subscribeNetworkQuery], кроме того позволяет указать обработчик
     * ошибок сетевых запросов
     */
    protected fun <T> subscribeNetworkQuery(observable: Observable<T>,
                                            onNext: Action1<T>,
                                            errorHandler: ErrorHandler): Subscription {
        return subscribeNetworkQuery(observable, onNext, null, errorHandler)
    }

    /**
     * Работает также как [.subscribeNetworkQuery], кроме того позволяет указать обработчик
     * ошибок сетевых запросов
     */
    protected fun <T> subscribeNetworkQuery(observable: Observable<T>,
                                            onNext: Action1<T>,
                                            onError: Action1<Throwable>?,
                                            errorHandler: ErrorHandler): Subscription {
        var observable = observable
        observable = observable.subscribeOn(Schedulers.io())
        return subscribe<T>(observable, { onNext }, { t: Throwable -> onNetworkError(t, onError, errorHandler) })
    }

    private fun onNetworkError(e: Throwable, onError: Action1<Throwable>?, errorHandler: ErrorHandler) {
        errorHandler.handleError(e)
        onError?.call(e)
    }
}
