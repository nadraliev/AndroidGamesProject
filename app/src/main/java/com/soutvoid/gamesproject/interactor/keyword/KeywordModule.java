package com.soutvoid.gamesproject.interactor.keyword;


import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.interactor.keyword.network.KeywordApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class KeywordModule {

    @Provides
    @PerApplication
    public KeywordApi provideKeywordApi(Retrofit retrofit) {
        return retrofit.create(KeywordApi.class);
    }

}
