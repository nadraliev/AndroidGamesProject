package com.soutvoid.gamesproject.ui.screen.personalize;

import com.agna.ferro.mvp.component.ScreenComponent;
import com.soutvoid.gamesproject.app.dagger.AppComponent;
import com.soutvoid.gamesproject.ui.common.dagger.ActivityViewModule;

import dagger.Component;

@Component(dependencies = AppComponent.class, modules = ActivityViewModule.class)
public interface PersonalizeActivityComponent extends ScreenComponent<PersonalizeActivityView> {
}
