package com.soutvoid.gamesproject.ui;

import com.agna.ferro.mvp.component.ScreenComponent;
import com.agna.ferro.mvp.component.scope.PerScreen;
import com.soutvoid.gamesproject.app.dagger.AppComponent;
import com.soutvoid.gamesproject.ui.base.activity.ActivityModule;
import com.soutvoid.gamesproject.ui.base.activity.BaseActivityView;

import dagger.Component;

/**
 * Created by andrew on 2/21/17.
 */

@PerScreen
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface MainActivityComponent extends ScreenComponent<BaseActivityView> {
}
