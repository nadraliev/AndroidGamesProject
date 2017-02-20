package com.soutvoid.gamesproject.app.dagger;

import android.content.Context;

import com.agna.ferro.mvp.component.scope.PerApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andrew on 2/20/17.
 */
@Module
public class AppModule {

    private Context appContext;

    public AppModule(Context appContext) {
        this.appContext = appContext;
    }

    @Provides
    @PerApplication
    Context provideContext() {
        return appContext;
    }

}
