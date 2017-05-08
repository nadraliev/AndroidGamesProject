package com.soutvoid.gamesproject.ui.screen.main;

import com.agna.ferro.mvp.component.scope.PerScreen;
import com.soutvoid.gamesproject.domain.game.fields.GameFields;
import com.soutvoid.gamesproject.interactor.game.GameRepository;
import com.soutvoid.gamesproject.interactor.util.Fields;
import com.soutvoid.gamesproject.interactor.util.Filter;
import com.soutvoid.gamesproject.interactor.util.Order;
import com.soutvoid.gamesproject.interactor.util.Query;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.common.error.ErrorHandler;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;


@PerScreen
public class MainActivityPresenter extends BasePresenter<MainActivityView> {

    private GameRepository gameRepository;
    private Realm realm;

    @Inject
    public MainActivityPresenter(ErrorHandler errorHandler,
                                 GameRepository gameRepository) {
        super(errorHandler);
        this.gameRepository = gameRepository;
    }


    @Override
    public void onLoad(boolean viewRecreated) {
        super.onLoad(viewRecreated);

        //main showcase query
        Query query = new Query(
                "Showcase",
                null,
                Fields.builder().build(),
                20,
                0,
                Order.builder().field(GameFields.POPULARITY.toString()).build(),
                Filter.builder().field(GameFields.FIRST_RELEASE_DATE.toString()).factor(Filter.Factor.gt.toString()).value("1483228800000").build()
        );

        subscribeNetworkQuery(gameRepository.searchGames(query),
                games -> getView().onSetShowcaseViewGames(games));
    }

    @Override
    public void onResume() {
        super.onResume();

        refreshExploreSets();
    }

    private synchronized void refreshExploreSets() {
        getView().onDeleteAllExploreSets();
        realm = Realm.getDefaultInstance();
        List<Query> queries = realm.copyFromRealm(realm.where(Query.class).findAll());
        realm.close();
        for (Query query : queries)
            subscribeNetworkQuery(gameRepository.searchGames(query),
                    games -> getView().onAddExploreSetView(query.getName(), games));
    }
}
