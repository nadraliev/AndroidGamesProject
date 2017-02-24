package com.soutvoid.gamesproject.interactor.platform;


import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.interactor.platform.network.PlatformApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class PlatformModule {

    @Provides
    @PerApplication
    public PlatformApi providePlatformApi(Retrofit retrofit) {
        return retrofit.create(PlatformApi.class);
    }

}
