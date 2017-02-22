package com.soutvoid.gamesproject.ui;

import com.agna.ferro.mvp.component.scope.PerScreen;
import com.soutvoid.gamesproject.app.dagger.AppComponent;
import com.soutvoid.gamesproject.interactor.character.CharacterModule;
import com.soutvoid.gamesproject.interactor.game.GameModule;

import dagger.Component;

/**
 * Created by andrew on 2/21/17.
 */

@PerScreen
@Component(dependencies = AppComponent.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
