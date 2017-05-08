package com.soutvoid.gamesproject.ui.screen.editQuery;

import com.agna.ferro.mvp.component.scope.PerScreen;
import com.soutvoid.gamesproject.domain.game.fields.GameFields;
import com.soutvoid.gamesproject.interactor.util.Fields;
import com.soutvoid.gamesproject.interactor.util.Filter;
import com.soutvoid.gamesproject.interactor.util.Order;
import com.soutvoid.gamesproject.interactor.util.Query;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.common.error.ErrorHandler;

import javax.inject.Inject;

import io.realm.Realm;

@PerScreen
public class EditQueryActivityPresenter extends BasePresenter<EditQueryActivityView> {

    Realm realm;

    @Inject
    public EditQueryActivityPresenter(ErrorHandler errorHandler) {
        super(errorHandler);
    }

    void onSaveClick() {
        gatherAndSaveQuery();
        getView().finish();
    }

    private synchronized void gatherAndSaveQuery() {
        Query query = new Query(
                getView().getNameInput(),
                null,
                Fields.builder().build(),
                20,
                0,
                Order.builder().field(GameFields.POPULARITY.toString()).build(),
                Filter.builder().field(GameFields.FIRST_RELEASE_DATE.toString()).factor(Filter.Factor.gt.toString()).value("1483228800000").build()
        );
        realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> realm1.copyToRealm(query));
        realm.close();
    }
}