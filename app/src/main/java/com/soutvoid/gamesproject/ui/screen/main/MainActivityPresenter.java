package com.soutvoid.gamesproject.ui.screen.main;

import com.agna.ferro.mvp.component.scope.PerScreen;
import com.soutvoid.gamesproject.domain.game.fields.GameFields;
import com.soutvoid.gamesproject.interactor.game.GameRepository;
import com.soutvoid.gamesproject.interactor.util.FieldsBuilder;
import com.soutvoid.gamesproject.interactor.util.FilterBuilder;
import com.soutvoid.gamesproject.interactor.util.OrderBuilder;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.common.error.ErrorHandler;

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
                "Portal",
                fieldsBuilder.addAllFields().build(),
                20,
                0,
                orderBuilder.addField(GameFields.POPULARITY).build(),
                filterBuilder.setField(GameFields.FIRST_RELEASE_DATE).setFactor(FilterBuilder.Factor.gt).setValue("1483228800000").buildMap()
        ), games -> {
            getView().onAddExploreSetView("Fresh popular", games);
        }, throwable -> {

        });
    }
}
