package com.soutvoid.gamesproject.interactor.game;

import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.interactor.game.network.GameApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by andrew on 2/21/17.
 */

@Module
public class GameModule {

    @Provides
    @PerApplication
    public GameApi provideGameApi(Retrofit retrofit) {
        return retrofit.create(GameApi.class);
    }

}
