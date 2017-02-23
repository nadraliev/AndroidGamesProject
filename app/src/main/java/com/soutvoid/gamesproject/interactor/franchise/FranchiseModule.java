package com.soutvoid.gamesproject.interactor.franchise;

import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.interactor.franchise.network.FranchiseApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by andrew on 2/23/17.
 */

@Module
public class FranchiseModule {

    @Provides
    @PerApplication
    public FranchiseApi provideFranchiseApi(Retrofit retrofit) {
        return retrofit.create(FranchiseApi.class);
    }

}
