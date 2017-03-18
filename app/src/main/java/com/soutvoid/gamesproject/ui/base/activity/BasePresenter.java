package com.soutvoid.gamesproject.ui.base.activity;

import com.agna.ferro.mvp.view.BaseView;
import com.agna.ferro.mvprx.MvpRxPresenter;
import com.soutvoid.gamesproject.ui.common.error.ErrorHandler;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * Created by andrew on 2/25/17.
 */

public class BasePresenter<V extends BaseView> extends MvpRxPresenter<V> {

    private ErrorHandler errorHandler;

    public BasePresenter(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    @Override
    protected <T> Subscription subscribe(Observable<T> observable,
                                         Action1<T> onNext,
                                         Action1<Throwable> onError) {
        observable = observable.observeOn(AndroidSchedulers.mainThread(), true);
        return super.subscribe(observable, onNext, onError);
    }

    @Override
    protected <T> Subscription subscribe(Observable<T> observable,
                                         Func2<T, T, Boolean> replaceFrozenEventPredicate,
                                         Action1<T> onNext,
                                         Action1<Throwable> onError) {
        observable = observable.observeOn(AndroidSchedulers.mainThread(), true);
        return super.subscribe(observable, replaceFrozenEventPredicate, onNext, onError);
    }

    @Override
    protected <T> Subscription subscribe(Observable<T> observable,
                                         Func2<T, T, Boolean> replaceFrozenEventPredicate,
                                         Subscriber<T> subscriber) {
        observable = observable.observeOn(AndroidSchedulers.mainThread(), true);
        return super.subscribe(observable, replaceFrozenEventPredicate, subscriber);
    }

    @Override
    protected <T> Subscription subscribe(Observable<T> observable,
                                         Subscriber<T> subscriber) {
        observable = observable.observeOn(AndroidSchedulers.mainThread(), true);
        return super.subscribe(observable, subscriber);
    }

    @Override
    protected <T> Subscription subscribeWithoutFreezing(Observable<T> observable,
                                                        Action1<T> onNext,
                                                        Action1<Throwable> onError) {
        return super.subscribeWithoutFreezing(observable, onNext, onError);
    }

    @Override
    protected <T> Subscription subscribeWithoutFreezing(Observable<T> observable,
                                                        Subscriber<T> subscriber) {
        observable = observable.observeOn(AndroidSchedulers.mainThread(), true);
        return super.subscribeWithoutFreezing(observable, subscriber);
    }

    /**
     * Работает также как {@link #subscribe}, кроме того предоставляет стандартную обработку
     * ошибок сетевых запросов
     */
    protected <T> Subscription subscribeNetworkQuery(Observable<T> observable,
                                                     final Action1<T> onNext,
                                                     final Action1<Throwable> onError) {
        return subscribeNetworkQuery(observable, onNext, onError, errorHandler);
    }

    /**
     * Работает также как {@link #subscribe}, кроме того предоставляет стандартную обработку
     * ошибок сетевых запросов
     */
    protected <T> Subscription subscribeNetworkQuery(Observable<T> observable,
                                                     final Action1<T> onNext) {
        return subscribeNetworkQuery(observable, onNext, null, errorHandler);
    }

    /**
     * Работает также как {@link #subscribeNetworkQuery}, кроме того позволяет указать обработчик
     * ошибок сетевых запросов
     */
    protected <T> Subscription subscribeNetworkQuery(Observable<T> observable,
                                                     final Action1<T> onNext,
                                                     ErrorHandler errorHandler) {
        return subscribeNetworkQuery(observable, onNext, null, errorHandler);
    }

    /**
     * Работает также как {@link #subscribeNetworkQuery}, кроме того позволяет указать обработчик
     * ошибок сетевых запросов
     */
    protected <T> Subscription subscribeNetworkQuery(Observable<T> observable,
                                                     final Action1<T> onNext,
                                                     final Action1<Throwable> onError,
                                                     ErrorHandler errorHandler) {
        observable = observable.subscribeOn(Schedulers.io());
        return subscribe(observable, onNext, e -> onNetworkError(e, onError, errorHandler));
    }

    private void onNetworkError(Throwable e, Action1<Throwable> onError, ErrorHandler errorHandler) {
        errorHandler.handleError(e);
        if (onError != null) {
            onError.call(e);
        }
    }
}
