package com.soutvoid.gamesproject.ui.screen.main;

import com.agna.ferro.mvp.component.scope.PerScreen;
import com.soutvoid.gamesproject.domain.game.fields.GameFields;
import com.soutvoid.gamesproject.interactor.game.GameRepository;
import com.soutvoid.gamesproject.interactor.util.FieldsBuilder;
import com.soutvoid.gamesproject.interactor.util.FilterBuilder;
import com.soutvoid.gamesproject.interactor.util.OrderBuilder;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.common.error.ErrorHandler;

import java.util.HashMap;

import javax.inject.Inject;


@PerScreen
public class MainActivityPresenter extends BasePresenter<MainActivityView> {

    private GameRepository gameRepository;

    @Inject
    public MainActivityPresenter(ErrorHandler errorHandler, GameRepository gameRepository) {
        super(errorHandler);
        this.gameRepository = gameRepository;
    }


    @Override
    public void onLoad(boolean viewRecreated) {
        super.onLoad(viewRecreated);
        FieldsBuilder fieldsBuilder = new FieldsBuilder();
        OrderBuilder orderBuilder = new OrderBuilder();
        FilterBuilder filterBuilder = new FilterBuilder();

        subscribeNetworkQuery(gameRepository.searchGames(
                null,
                fieldsBuilder.addAllFields().build(),
                20,
                0,
                orderBuilder.addField(GameFields.POPULARITY).build(),
                filterBuilder.setField(GameFields.FIRST_RELEASE_DATE).setFactor(FilterBuilder.Factor.gt).setValue("1483228800000").buildMap()
        ), games -> getView().onSetShowcaseViewGames(games));

        subscribeNetworkQuery(gameRepository.searchGames(
                null,
                fieldsBuilder.addAllFields().build(),
                20,
                0,
                orderBuilder.clear().addField(GameFields.POPULARITY).build(),
                filterBuilder.clear().setField(GameFields.FIRST_RELEASE_DATE).setFactor(FilterBuilder.Factor.gt).setValue("1483228800000").buildMap()
        ), games -> getView().onAddExploreSetView("Fresh popular", games));

        subscribeNetworkQuery(gameRepository.searchGames(
                null,
                fieldsBuilder.clear().addAllFields().build(),
                20,
                0,
                orderBuilder.clear().addField(GameFields.FIRST_RELEASE_DATE).build(),
                new HashMap<String, String>()
        ), games -> getView().onAddExploreSetView("Just came out", games));

        subscribeNetworkQuery(gameRepository.searchGames(
                null,
                fieldsBuilder.clear().addAllFields().build(),
                20,
                0,
                orderBuilder.clear().addField(GameFields.POPULARITY).build(),
                filterBuilder.clear().setField(GameFields.GENRES).setFactor(FilterBuilder.Factor.in).setValue("2").buildMap()   //TODO make enum for genres
        ), games -> getView().onAddExploreSetView("Point-and-click", games));
    }
}
