package com.soutvoid.gamesproject.ui.screen.game;

import com.agna.ferro.mvp.component.scope.PerScreen;
import com.soutvoid.gamesproject.domain.game.Game;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.common.error.ErrorHandler;

import javax.inject.Inject;

@PerScreen
public class GameActivityPresenter extends BasePresenter<GameActivityView> {

    private Game game;

    @Inject
    public GameActivityPresenter(ErrorHandler errorHandler) {
        super(errorHandler);
    }

    @Override
    public void onLoad(boolean viewRecreated) {
        super.onLoad(viewRecreated);

        game = (Game) getView().getIntent().getSerializableExtra("game");
    }

    @Override
    public void onLoadFinished() {
        super.onLoadFinished();

        if (game.getScreenshots() != null && game.getScreenshots().size() > 0)
            getView().downloadTopImage(game.getScreenshots().get(0).getUrl());
    }
}
