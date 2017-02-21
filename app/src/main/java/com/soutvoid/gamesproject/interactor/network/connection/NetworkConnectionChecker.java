package com.soutvoid.gamesproject.interactor.network.connection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.agna.ferro.mvp.component.scope.PerApplication;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;

/**
 * Позволяет проверить есть ли сейчас Интернет и подписаться на изменение статуса соединения с Интернетом
 */
@PerApplication
public class NetworkConnectionChecker {

    private final Context context;

    @Inject
    public NetworkConnectionChecker(Context context) {
        this.context = context;
    }

    public boolean hasInternetConnection() {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    /**
     * Эмитит true, когда появляется интернет
     */
    public Observable<Boolean> onHaveInternetStatus() {
        return Observable.interval(0, 10, TimeUnit.SECONDS)
                .map(t -> hasInternetConnection())
                .filter(connected -> connected)
                .first();
    }
}
