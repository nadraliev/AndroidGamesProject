package com.soutvoid.gamesproject.ui.screen.main;

import com.agna.ferro.mvp.component.ScreenComponent;
import com.agna.ferro.mvp.component.scope.PerScreen;
import com.soutvoid.gamesproject.app.dagger.AppComponent;
import com.soutvoid.gamesproject.ui.common.dagger.ActivityViewModule;

import dagger.Component;

/**
 * Created by andrew on 2/21/17.
 */

@PerScreen
@Component(dependencies = AppComponent.class, modules = {ActivityViewModule.class})
interface MainActivityComponent extends ScreenComponent<MainActivityView> {
}
