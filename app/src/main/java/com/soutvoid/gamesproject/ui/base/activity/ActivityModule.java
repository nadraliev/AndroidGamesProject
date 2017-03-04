package com.soutvoid.gamesproject.ui.base.activity;

import com.agna.ferro.core.PersistentScreenScope;
import com.agna.ferro.mvp.component.provider.ActivityProvider;
import com.agna.ferro.mvp.component.scope.PerApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private PersistentScreenScope persistentScreenScope;

    public ActivityModule(PersistentScreenScope persistentScreenScope) {
        this.persistentScreenScope = persistentScreenScope;
    }

    @Provides
    @PerApplication
    public ActivityProvider getActivityProvider() {
        return new ActivityProvider(persistentScreenScope);
    }
}
