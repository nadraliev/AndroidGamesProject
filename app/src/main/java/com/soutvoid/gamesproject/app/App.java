package com.soutvoid.gamesproject.app;

import android.app.Application;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatDelegate;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.core.BuildConfig;
import com.crashlytics.android.core.CrashlyticsCore;
import com.facebook.stetho.Stetho;
import com.github.anrwatchdog.ANRWatchDog;
import com.soutvoid.gamesproject.app.dagger.AppComponent;
import com.soutvoid.gamesproject.app.dagger.AppModule;
import com.soutvoid.gamesproject.app.dagger.DaggerAppComponent;
import com.soutvoid.gamesproject.app.log.Logger;
import com.soutvoid.gamesproject.app.log.RemoteLogger;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import soutvoid.com.gamesproject.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        MultiDex.install(getApplicationContext());
        super.onCreate();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        initFabric();
        initAnrWatchDog();
        initInjector();
        initLog();
        initCalligraphy();
        initStetho();
    }

    private void initAnrWatchDog() {
        new ANRWatchDog().setReportMainThreadOnly().setANRListener(RemoteLogger::logError).start();
    }

    private void initFabric() {
        final Kit[] kits = {
                new Crashlytics.Builder().core(new CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build()).build()
        };
        Fabric.with(this, kits);
    }

    private void initInjector() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    private void initLog() {
        Logger.init();
    }

    private void initCalligraphy() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Roboto-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }

    private void initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build()
        );
    }

    public AppComponent getAppComponent() {
        return this.appComponent;
    }
}
