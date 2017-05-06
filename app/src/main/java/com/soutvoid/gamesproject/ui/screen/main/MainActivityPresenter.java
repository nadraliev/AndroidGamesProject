package com.soutvoid.gamesproject.ui.screen.main;

import com.agna.ferro.mvp.component.scope.PerScreen;
import com.soutvoid.gamesproject.domain.game.fields.GameFields;
import com.soutvoid.gamesproject.interactor.game.GameRepository;
import com.soutvoid.gamesproject.interactor.util.FieldsBuilder;
import com.soutvoid.gamesproject.interactor.util.Filter;
import com.soutvoid.gamesproject.interactor.util.Order;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.common.error.ErrorHandler;

import javax.inject.Inject;


@PerScreen
public class MainActivityPresenter extends BasePresenter<MainActivityView> {

    private final int DATA_TO_LOAD = 4;

    private GameRepository gameRepository;
    private int dataLoaded = 0;

    @Inject
    public MainActivityPresenter(ErrorHandler errorHandler, GameRepository gameRepository) {
        super(errorHandler);
        this.gameRepository = gameRepository;
    }


    @Override
    public void onLoad(boolean viewRecreated) {
        super.onLoad(viewRecreated);
        FieldsBuilder fieldsBuilder = new FieldsBuilder();

        getView().showPlaceholderWithBackground();

        subscribeNetworkQuery(gameRepository.searchGames(
                null,
                fieldsBuilder.addAllFields().build(),
                20,
                0,
                Order.builder().field(GameFields.POPULARITY.toString()).build(),
                Filter.builder().field(GameFields.FIRST_RELEASE_DATE.toString()).factor(Filter.Factor.gt.toString()).value("1483228800000").build()
        ), games -> {
            getView().onSetShowcaseViewGames(games);
            dataLoaded();
        });

        subscribeNetworkQuery(gameRepository.searchGames(
                null,
                fieldsBuilder.addAllFields().build(),
                20,
                0,
                Order.builder().field(GameFields.POPULARITY.toString()).build(),
                Filter.builder().field(GameFields.FIRST_RELEASE_DATE.toString()).factor(Filter.Factor.gt.toString()).value("1483228800000").build()
        ), games -> {
            getView().onAddExploreSetView("Fresh popular", games);
            dataLoaded();
        });

        subscribeNetworkQuery(gameRepository.searchGames(
                null,
                fieldsBuilder.clear().addAllFields().build(),
                20,
                0,
                Order.builder().field(GameFields.FIRST_RELEASE_DATE.toString()).build(),
                Filter.builder().build()
        ), games -> {
            getView().onAddExploreSetView("Just came out", games);
            dataLoaded();
        });

        subscribeNetworkQuery(gameRepository.searchGames(
                null,
                fieldsBuilder.clear().addAllFields().build(),
                20,
                0,
                Order.builder().field(GameFields.POPULARITY.toString()).build(),
                Filter.builder().field(GameFields.GENRES.toString()).factor(Filter.Factor.in.toString()).value("2").build() //TODO make enum for genres
        ), games -> {
            getView().onAddExploreSetView("Point-and-click", games);
            dataLoaded();
        });
    }

    private void dataLoaded() {
        if (++dataLoaded == DATA_TO_LOAD)
            getView().hidePlaceholder();
    }
}
