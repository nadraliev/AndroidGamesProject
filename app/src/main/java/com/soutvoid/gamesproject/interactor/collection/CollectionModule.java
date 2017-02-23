package com.soutvoid.gamesproject.interactor.collection;

import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.interactor.collection.network.CollectionApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by andrew on 2/23/17.
 */

@Module
public class CollectionModule {

    @Provides
    @PerApplication
    public CollectionApi provideCollectionApi(Retrofit retrofit) {
        return retrofit.create(CollectionApi.class);
    }

}
