package com.soutvoid.gamesproject.interactor.common.network.cache;


import android.content.Context;

import com.agna.ferro.mvp.component.scope.PerApplication;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;

@Module
public class CacheModule {

    @Provides
    @PerApplication
    Cache provideCache(Context context) {
        return new Cache(getCacheDirectory(context), 1024 * 1024 * 10);
    }

    public File getCacheDirectory(Context context) {
        return new File(context.getCacheDir(), "http-cache");
    }

}
