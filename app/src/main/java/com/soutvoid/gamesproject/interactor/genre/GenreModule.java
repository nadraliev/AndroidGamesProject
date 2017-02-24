package com.soutvoid.gamesproject.interactor.genre;


import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.interactor.genre.network.GenreApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class GenreModule {

    @Provides
    @PerApplication
    public GenreApi provideGenreApi(Retrofit retrofit) {
        return retrofit.create(GenreApi.class);
    }

}
