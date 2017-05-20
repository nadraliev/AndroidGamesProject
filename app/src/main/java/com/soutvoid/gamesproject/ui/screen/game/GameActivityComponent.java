package com.soutvoid.gamesproject.ui.screen.game;

import com.agna.ferro.mvp.component.ScreenComponent;
import com.agna.ferro.mvp.component.scope.PerScreen;
import com.soutvoid.gamesproject.app.dagger.AppComponent;
import com.soutvoid.gamesproject.ui.common.dagger.ActivityViewModule;

import dagger.Component;

@PerScreen
@Component(dependencies = AppComponent.class, modules = ActivityViewModule.class)
public interface GameActivityComponent extends ScreenComponent<GameActivityView> {
}