package com.soutvoid.gamesproject.interactor.network.connection

import android.content.Context
import android.net.ConnectivityManager
import com.agna.ferro.mvp.component.scope.PerApplication
import rx.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Позволяет проверить есть ли сейчас Интернет и подписаться на изменение статуса соединения с Интернетом
 */
@PerApplication
class NetworkConnectionChecker @Inject
constructor(private val context: Context) {

    fun hasInternetConnection(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }

    /**
     * Эмитит true, когда появляется интернет
     */
    fun onHaveInternetStatus(): Observable<Boolean> {
        return Observable.interval(0, 10, TimeUnit.SECONDS)
                .map { hasInternetConnection() }
                .filter { connected -> connected }
                .first()
    }
}
