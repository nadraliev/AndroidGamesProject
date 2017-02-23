package com.soutvoid.gamesproject.interactor.company;

import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.interactor.company.network.CompanyApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by andrew on 2/23/17.
 */

@Module
public class CompanyModule {

    @Provides
    @PerApplication
    public CompanyApi provideCompanyApi(Retrofit retrofit) {
        return retrofit.create(CompanyApi.class);
    }

}
