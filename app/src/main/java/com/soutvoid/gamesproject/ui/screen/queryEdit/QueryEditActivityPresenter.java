package com.soutvoid.gamesproject.ui.screen.queryEdit;

import com.agna.ferro.mvp.component.scope.PerScreen;
import com.soutvoid.gamesproject.domain.game.fields.GameFields;
import com.soutvoid.gamesproject.interactor.util.ExploreQuery;
import com.soutvoid.gamesproject.interactor.util.Fields;
import com.soutvoid.gamesproject.interactor.util.Filter;
import com.soutvoid.gamesproject.interactor.util.Order;
import com.soutvoid.gamesproject.interactor.util.Query;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.common.error.ErrorHandler;

import javax.inject.Inject;

import io.realm.Realm;

@PerScreen
public class QueryEditActivityPresenter extends BasePresenter<QueryEditActivityView> {

    Realm realm;

    @Inject
    public QueryEditActivityPresenter(ErrorHandler errorHandler) {
        super(errorHandler);
    }

    void onSaveClick() {
        gatherAndSaveQuery();
        getView().finish();
    }

    private synchronized void gatherAndSaveQuery() {
        realm = Realm.getDefaultInstance();

        // increment index
        int nextId = (int) (realm.where(ExploreQuery.class).count());

        Query query = new Query(
                null,
                Fields.builder().build(),
                20,
                0,
                Order.builder().field(GameFields.POPULARITY.toString()).build(),
                Filter.builder().field(GameFields.FIRST_RELEASE_DATE.toString()).factor(Filter.Factor.gt.toString()).value("1483228800000").build()
        );
        ExploreQuery exploreQuery = new ExploreQuery(
                nextId,
                getView().getNameInput(),
                query
        );

        realm.executeTransaction(realm1 -> realm1.copyToRealm(exploreQuery));
        realm.close();
    }
}
