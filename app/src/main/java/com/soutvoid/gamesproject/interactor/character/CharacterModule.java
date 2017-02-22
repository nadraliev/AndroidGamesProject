package com.soutvoid.gamesproject.interactor.character;

import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.interactor.character.network.CharacterApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by andrew on 22-Feb-17.
 */

@Module
public class CharacterModule {

    @Provides
    @PerApplication
    public CharacterApi provideCharacterApi(Retrofit retrofit) {
        return retrofit.create(CharacterApi.class);
    }

}
