package com.soutvoid.gamesproject.ui.screen.game;

import com.agna.ferro.mvp.component.scope.PerScreen;
import com.soutvoid.gamesproject.domain.game.Game;
import com.soutvoid.gamesproject.domain.game.enums.GameStatus;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.common.error.ErrorHandler;

import java.util.Calendar;

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

        fillInfo();
    }

    private void fillInfo() {
        if (game.getScreenshots() != null && game.getScreenshots().size() > 0)
            getView().downloadTopImage(game.getScreenshots().get(0).getUrl());

        if (game.getCover() != null)
            getView().downloadCover(game.getCover().getUrl());

        getView().showTitle(game.getName());

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(game.getFirstReleaseDate());
        getView().showYear(String.valueOf(calendar.get(Calendar.YEAR)));


        String status = "";
        if (game.getStatus() != null)
            status = GameStatus.values()[game.getStatus()].getValue();
        else {
            if (Calendar.getInstance().getTimeInMillis() > game.getFirstReleaseDate())
                status = GameStatus.values()[0].getValue();
            else status = GameStatus.values()[4].getValue();
        }
        getView().showStatus(status);
    }
}
