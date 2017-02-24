package com.soutvoid.gamesproject.interactor.person;


import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.interactor.person.network.PersonApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class PersonModule {

    @Provides
    @PerApplication
    public PersonApi providePersonApi(Retrofit retrofit) {
        return retrofit.create(PersonApi.class);
    }

}
