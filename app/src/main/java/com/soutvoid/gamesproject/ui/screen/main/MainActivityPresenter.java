package com.soutvoid.gamesproject.ui.screen.main;

import com.agna.ferro.mvp.component.scope.PerScreen;
import com.soutvoid.gamesproject.domain.game.Game;
import com.soutvoid.gamesproject.domain.game.fields.GameFields;
import com.soutvoid.gamesproject.interactor.game.GameRepository;
import com.soutvoid.gamesproject.interactor.util.FieldsBuilder;
import com.soutvoid.gamesproject.interactor.util.FilterBuilder;
import com.soutvoid.gamesproject.interactor.util.OrderBuilder;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.common.error.ErrorHandler;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import rx.functions.Action1;


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
        HashMap<String, String> map = new HashMap<>();
        subscribeNetworkQuery(gameRepository.searchGames(
                "Portal",
                fieldsBuilder.addAllFields().build(),
                20,
                0,
                orderBuilder.addField(GameFields.POPULARITY).build(),
                map
        ), new Action1<ArrayList<Game>>() {
            @Override
            public void call(ArrayList<Game> games) {
                getView().exploreSetViewPopular.setGamesListContent(games);
                getView().exploreSetViewPopular.chooseBackgroundFromGamesList();
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

            }
        });
    }
}
