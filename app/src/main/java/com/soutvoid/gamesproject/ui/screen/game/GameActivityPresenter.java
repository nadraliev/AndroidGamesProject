package com.soutvoid.gamesproject.ui.screen.game;

import com.agna.ferro.mvp.component.scope.PerScreen;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.common.error.ErrorHandler;

import javax.inject.Inject;

@PerScreen
public class GameActivityPresenter extends BasePresenter<GameActivityView> {

    @Inject
    public GameActivityPresenter(ErrorHandler errorHandler) {
        super(errorHandler);
    }


}
