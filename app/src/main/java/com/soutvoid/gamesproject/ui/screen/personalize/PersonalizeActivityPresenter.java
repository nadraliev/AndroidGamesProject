package com.soutvoid.gamesproject.ui.screen.personalize;

import com.agna.ferro.mvp.component.scope.PerScreen;
import com.soutvoid.gamesproject.interactor.util.ExploreQuery;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.common.error.ErrorHandler;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;

@PerScreen
public class PersonalizeActivityPresenter extends BasePresenter<PersonalizeActivityView> {

    private Realm realm;

    @Inject
    public PersonalizeActivityPresenter(ErrorHandler errorHandler) {
        super(errorHandler);
    }

    @Override
    public void onLoad(boolean viewRecreated) {
        super.onLoad(viewRecreated);

    }

    @Override
    public void onResume() {
        super.onResume();
        refreshQueries();
    }

    private synchronized void refreshQueries() {
        realm = Realm.getDefaultInstance();
        RealmResults<ExploreQuery> exploreQueries = realm.where(ExploreQuery.class).findAll();
        getView().setQueriesContent(realm.copyFromRealm(exploreQueries));
        realm.close();
    }
}
