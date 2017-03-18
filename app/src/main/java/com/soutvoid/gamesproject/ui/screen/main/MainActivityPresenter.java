package com.soutvoid.gamesproject.ui.screen.main;

import com.agna.ferro.mvp.component.scope.PerScreen;
import com.soutvoid.gamesproject.interactor.game.GameRepository;
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
    }
}
