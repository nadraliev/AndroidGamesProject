package com.soutvoid.gamesproject.interactor.common;

import com.agna.ferro.mvp.component.scope.PerScreen;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class RealmModule {

    @Provides
    @PerScreen
    Realm provideRealm() {
        return Realm.getDefaultInstance();
    }

}
