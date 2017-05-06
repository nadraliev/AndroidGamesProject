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

import javax.inject.Inject;

import io.realm.Realm;


@PerScreen
public class MainActivityPresenter extends BasePresenter<MainActivityView> {

    private final int DATA_TO_LOAD = 4;

    private GameRepository gameRepository;
    private Realm realm;
    private int dataLoaded = 0;

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

    private void dataLoaded() {
        if (++dataLoaded == DATA_TO_LOAD)
            getView().hidePlaceholder();
    }
}
