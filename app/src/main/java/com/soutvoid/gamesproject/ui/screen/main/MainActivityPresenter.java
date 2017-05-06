package com.soutvoid.gamesproject.ui.screen.main;

import com.agna.ferro.mvp.component.scope.PerScreen;
import com.soutvoid.gamesproject.interactor.game.GameRepository;
import com.soutvoid.gamesproject.interactor.util.Query;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.common.error.ErrorHandler;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;


@PerScreen
public class MainActivityPresenter extends BasePresenter<MainActivityView> {

    private final int DATA_TO_LOAD = 4;

    private GameRepository gameRepository;
    private Realm realm;
    private int dataLoaded = 0;

    @Inject
    public MainActivityPresenter(ErrorHandler errorHandler,
                                 GameRepository gameRepository,
                                 Realm realm) {
        super(errorHandler);
        this.gameRepository = gameRepository;
        this.realm = realm;
    }


    @Override
    public void onLoad(boolean viewRecreated) {
        super.onLoad(viewRecreated);

        getView().showPlaceholderWithBackground();

        RealmResults<Query> queries = realm.where(Query.class).findAll();

        subscribeNetworkQuery(gameRepository.searchGames(
                queries.get(0).getSearchQuery(),
                queries.get(0).getFields(),
                queries.get(0).getLimit(),
                queries.get(0).getOffset(),
                queries.get(0).getOrder(),
                queries.get(0).getFilter()
        ), games -> {
            getView().onSetShowcaseViewGames(games);
            dataLoaded();
        });

        subscribeNetworkQuery(gameRepository.searchGames(
                queries.get(1).getSearchQuery(),
                queries.get(1).getFields(),
                queries.get(1).getLimit(),
                queries.get(1).getOffset(),
                queries.get(1).getOrder(),
                queries.get(1).getFilter()
        ), games -> {
            getView().onAddExploreSetView("Fresh popular", games);
            dataLoaded();
        });

        subscribeNetworkQuery(gameRepository.searchGames(
                queries.get(2).getSearchQuery(),
                queries.get(2).getFields(),
                queries.get(2).getLimit(),
                queries.get(2).getOffset(),
                queries.get(2).getOrder(),
                queries.get(2).getFilter()
        ), games -> {
            getView().onAddExploreSetView("Just came out", games);
            dataLoaded();
        });

        subscribeNetworkQuery(gameRepository.searchGames(
                queries.get(3).getSearchQuery(),
                queries.get(3).getFields(),
                queries.get(3).getLimit(),
                queries.get(3).getOffset(),
                queries.get(3).getOrder(),
                queries.get(3).getFilter()
        ), games -> {
            getView().onAddExploreSetView("Point-and-click", games);
            dataLoaded();
        });

        realm.close();

    }

    private void dataLoaded() {
        if (++dataLoaded == DATA_TO_LOAD)
            getView().hidePlaceholder();
    }
}
