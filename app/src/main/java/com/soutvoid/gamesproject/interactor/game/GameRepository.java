package com.soutvoid.gamesproject.interactor.game;

import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.domain.game.Game;
import com.soutvoid.gamesproject.domain.game.GameEngine;
import com.soutvoid.gamesproject.domain.game.GameMode;
import com.soutvoid.gamesproject.interactor.game.network.GameApi;
import com.soutvoid.gamesproject.interactor.network.connection.NetworkConnectionChecker;
import com.soutvoid.gamesproject.interactor.util.FieldsBuilder;
import com.soutvoid.gamesproject.interactor.util.Filter;
import com.soutvoid.gamesproject.interactor.util.OrderBuilder;
import com.soutvoid.gamesproject.interactor.util.TransformUtil;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observable;

@PerApplication
public class GameRepository {

    private GameApi gameApi;
    private NetworkConnectionChecker networkConnectionChecker;

    @Inject
    public GameRepository(GameApi gameApi, NetworkConnectionChecker networkConnectionChecker) {
        this.gameApi = gameApi;
        this.networkConnectionChecker = networkConnectionChecker;
    }

    /**
     * поиск игр
     *
     * @param searchQuery поисковой запрос
     * @param fields      поля, которые необходимо включить в ответ. стрится с помощью {@link FieldsBuilder}
     * @param limit       лимит кол-ва результатов
     * @param offset      пагинация ответа
     * @param order       сортировка. стрится с помощью {@link OrderBuilder}
     * @return список игр
     */
    public Observable<ArrayList<Game>> searchGames(String searchQuery, String fields, int limit, int offset, String order) {
        return gameApi.searchForGames(fields, limit, offset, order, searchQuery)
                .flatMap(gameObjs -> Observable.just(TransformUtil.transformCollection(gameObjs)));
    }

    /**
     * то же, что {@link #searchGames(String, String, int, int, String)}, но с фильтром
     * @param filter  объект с фильтрами
     *                (ключ - параметры фильтрования, значение - собственно, значение, относительно которого сортировать)
     *                строится с помощью {@link Filter}
     */
    public Observable<ArrayList<Game>> searchGames(String searchQuery,
                                                   String fields,
                                                   int limit,
                                                   int offset,
                                                   String order,
                                                   Filter filter) {
        return gameApi.searchForGames(fields, limit, offset, order, searchQuery, filter.toMap())
                .flatMap(gameObjs -> Observable.just(TransformUtil.transformCollection(gameObjs)));
    }

    /**
     * получение игры по id
     * @param id
     * @param fields поля, включенные в ответ
     * @return массив. обычно состоящий из одной игры
     */
    public Observable<ArrayList<Game>> getGamesById(int id, String fields) {
        return gameApi.getGamesById(id, fields)
                .flatMap(gameObjs -> Observable.just(TransformUtil.transformCollection(gameObjs)));
    }

    /**
     * то же, что {@link #searchGames(String, String, int, int, String)}, но для движков
     */
    public Observable<ArrayList<GameEngine>> searchGameEngines(String searchQuery, String fields, int limit, int offset, String order) {
        return gameApi.searchForGameEngines(fields, limit, offset, order, searchQuery)
                .flatMap(gameEngineObjs -> Observable.just(TransformUtil.transformCollection(gameEngineObjs)));
    }

    /**
     * то же, что и {@link #searchGames(String, String, int, int, String, Filter)}, но для движков
     */
    public Observable<ArrayList<GameEngine>> searchGameEngines(String searchQuery,
                                                               String fields,
                                                               int limit,
                                                               int offset,
                                                               String order,
                                                               Filter filter) {
        return gameApi.searchForGameEngines(fields, limit, offset, order, searchQuery, filter.toMap())
                .flatMap(gameEngineObjs -> Observable.just(TransformUtil.transformCollection(gameEngineObjs)));
    }

    /**
     * то же, что и {@link #getGamesById(int, String)}, но для для движков
     */
    public Observable<ArrayList<GameEngine>> getGameEnginesById(int id, String fields) {
        return gameApi.getGameEnginesById(id, fields)
                .flatMap(gameEngineObjs -> Observable.just(TransformUtil.transformCollection(gameEngineObjs)));
    }

    /**
     * то же, что {@link #searchGames(String, String, int, int, String)}, но для игровых режимов
     */
    public Observable<ArrayList<GameMode>> searchGameModes(String searchQuery, String fields, int limit, int offset, String order) {
        return gameApi.searchForGameModes(fields, limit, offset, order, searchQuery)
                .flatMap(gameModeObjs -> Observable.just(TransformUtil.transformCollection(gameModeObjs)));
    }

    /**
     * то же, что и {@link #searchGames(String, String, int, int, String, Filter)}, но для игровых режимов
     */
    public Observable<ArrayList<GameMode>> searchGameModes(String searchQuery,
                                                           String fields,
                                                           int limit,
                                                           int offset,
                                                           String order,
                                                           Filter filter) {
        return gameApi.searchForGameModes(fields, limit, offset, order, searchQuery, filter.toMap())
                .flatMap(gameModeObjs -> Observable.just(TransformUtil.transformCollection(gameModeObjs)));
    }

    /**
     * то же, что и {@link #getGamesById(int, String)}, но для игровых режимов
     */
    public Observable<ArrayList<GameMode>> getGameModesById(int id, String fields) {
        return gameApi.getGameModesById(id, fields)
                .flatMap(gameModeObjs -> Observable.just(TransformUtil.transformCollection(gameModeObjs)));
    }
}
