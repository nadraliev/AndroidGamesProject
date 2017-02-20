package com.soutvoid.gamesproject.app;

import android.app.Application;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatDelegate;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.core.BuildConfig;
import com.crashlytics.android.core.CrashlyticsCore;
import com.github.anrwatchdog.ANRWatchDog;
import com.soutvoid.gamesproject.app.dagger.AppComponent;
import com.soutvoid.gamesproject.app.dagger.AppModule;
import com.soutvoid.gamesproject.app.dagger.DaggerAppComponent;
import com.soutvoid.gamesproject.app.log.RemoteLogger;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;

/**
 * Created by andrew on 2/20/17.
 */

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        MultiDex.install(getApplicationContext());
        super.onCreate();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
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

    public AppComponent getAppComponent() {
        return this.appComponent;
    }
}
