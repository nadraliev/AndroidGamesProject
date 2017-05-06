package com.soutvoid.gamesproject.ui.screen.main;

import com.agna.ferro.mvp.component.scope.PerScreen;
import com.soutvoid.gamesproject.interactor.game.GameRepository;
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

    }

    private void dataLoaded() {
        if (++dataLoaded == DATA_TO_LOAD)
            getView().hidePlaceholder();
    }
}
