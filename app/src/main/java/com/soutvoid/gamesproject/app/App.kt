package com.soutvoid.gamesproject.app

import android.app.Application
import android.support.multidex.MultiDex
import android.support.v7.app.AppCompatDelegate

import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.BuildConfig
import com.crashlytics.android.core.CrashlyticsCore
import com.facebook.stetho.Stetho
import com.github.anrwatchdog.ANRWatchDog
import com.soutvoid.gamesproject.app.dagger.AppComponent
import com.soutvoid.gamesproject.app.dagger.AppModule
import com.soutvoid.gamesproject.app.log.Logger
import com.soutvoid.gamesproject.app.log.RemoteLogger
import com.uphyca.stetho_realm.RealmInspectorModulesProvider

import io.fabric.sdk.android.Fabric
import io.fabric.sdk.android.Kit
import io.realm.Realm
import soutvoid.com.gamesproject.R
import uk.co.chrisjenx.calligraphy.CalligraphyConfig


class App : Application() {

    var appComponent: AppComponent? = null
        private set

    override fun onCreate() {
        MultiDex.install(applicationContext)
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        initFabric()
        initAnrWatchDog()
        initInjector()
        initLog()
        initCalligraphy()
        initStetho()
        initRealm()
    }

    private fun initAnrWatchDog() {
        ANRWatchDog().setReportMainThreadOnly().setANRListener(ANRWatchDog.ANRListener { RemoteLogger.logError(it) }).start()
    }

    private fun initFabric() {
        val kits = arrayOf<Kit<*>>(Crashlytics.Builder().core(CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build()).build())
        Fabric.with(this, *kits)
    }

    private fun initInjector() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    private fun initLog() {
        Logger.init()
    }

    private fun initCalligraphy() {
        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Roboto-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build())
    }

    private fun initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build()
        )
    }

    private fun initRealm() {
        Realm.init(this)
    }
}
