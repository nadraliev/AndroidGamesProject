package com.soutvoid.gamesproject.interactor.game;

import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.domain.game.Game;
import com.soutvoid.gamesproject.interactor.common.network.TransformUtil;
import com.soutvoid.gamesproject.interactor.game.network.GameApi;
import com.soutvoid.gamesproject.interactor.network.connection.NetworkConnectionChecker;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by andrew on 2/21/17.
 */

@PerApplication
public class GameRepository {

    private GameApi gameApi;
    private NetworkConnectionChecker networkConnectionChecker;

    @Inject
    public GameRepository(GameApi gameApi, NetworkConnectionChecker networkConnectionChecker) {
        this.gameApi = gameApi;
        this.networkConnectionChecker = networkConnectionChecker;
    }

    public Observable<ArrayList<Game>> getGames(String searchQuery) {
        return gameApi.searchForGames("*", 20, 0, "release_dates.date:desc", searchQuery)
                .map(TransformUtil::transform);
    }
}
