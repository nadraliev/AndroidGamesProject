package com.soutvoid.gamesproject.app.dagger;

import android.content.Context;

import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.interactor.character.CharacterModule;
import com.soutvoid.gamesproject.interactor.character.CharacterRepository;
import com.soutvoid.gamesproject.interactor.collection.CollectionModule;
import com.soutvoid.gamesproject.interactor.collection.CollectionRepository;
import com.soutvoid.gamesproject.interactor.common.network.NetworkModule;
import com.soutvoid.gamesproject.interactor.common.network.OkHttpModule;
import com.soutvoid.gamesproject.interactor.game.GameModule;
import com.soutvoid.gamesproject.interactor.game.GameRepository;
import com.soutvoid.gamesproject.interactor.network.connection.NetworkConnectionChecker;

import dagger.Component;

/**
 * Created by andrew on 2/20/17.
 */
@PerApplication
@Component(modules = {
        AppModule.class,
        OkHttpModule.class,
        NetworkModule.class,
        GameModule.class,
        CharacterModule.class,
        CollectionModule.class
})
public interface AppComponent {
    Context context();
    NetworkConnectionChecker networkConnectionChecker();
    GameRepository gameRepository();
    CharacterRepository characterRepository();

    CollectionRepository collectionRepository();
}
