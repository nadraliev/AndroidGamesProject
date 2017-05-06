package com.soutvoid.gamesproject.interactor.game;

import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.domain.game.Game;
import com.soutvoid.gamesproject.domain.game.GameEngine;
import com.soutvoid.gamesproject.domain.game.GameMode;
import com.soutvoid.gamesproject.interactor.game.network.GameApi;
import com.soutvoid.gamesproject.interactor.network.connection.NetworkConnectionChecker;
import com.soutvoid.gamesproject.interactor.util.Fields;
import com.soutvoid.gamesproject.interactor.util.Filter;
import com.soutvoid.gamesproject.interactor.util.Order;
import com.soutvoid.gamesproject.interactor.util.Query;
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
     * @param fields      поля, которые необходимо включить в ответ. стрится с помощью {@link Fields}
     * @param limit       лимит кол-ва результатов
     * @param offset      пагинация ответа
     * @param order       сортировка. стрится с помощью {@link Order}
     * @return список игр
     */
    public Observable<ArrayList<Game>> searchGames(String searchQuery, Fields fields, int limit, int offset, Order order) {
        return gameApi.searchForGames(fields.toString(), limit, offset, order.toString(), searchQuery)
                .flatMap(gameObjs -> Observable.just(TransformUtil.transformCollection(gameObjs)));
    }

    /**
     * то же, что {@link #searchGames(String, Fields, int, int, Order)}, но с фильтром
     * @param filter  объект с фильтрами
     *                (ключ - параметры фильтрования, значение - собственно, значение, относительно которого сортировать)
     *                строится с помощью {@link Filter}
     */
    public Observable<ArrayList<Game>> searchGames(String searchQuery,
                                                   Fields fields,
                                                   int limit,
                                                   int offset,
                                                   Order order,
                                                   Filter filter) {
        return gameApi.searchForGames(fields.toString(), limit, offset, order.toString(), searchQuery, filter.toMap())
                .flatMap(gameObjs -> Observable.just(TransformUtil.transformCollection(gameObjs)));
    }

    public Observable<ArrayList<Game>> searchGames(Query query) {
        return searchGames(
                query.getSearchQuery(),
                query.getFields(),
                query.getLimit(),
                query.getOffset(),
                query.getOrder(),
                query.getFilter());
    }

    /**
     * получение игры по id
     * @param id
     * @param fields поля, включенные в ответ
     * @return массив. обычно состоящий из одной игры
     */
    public Observable<ArrayList<Game>> getGamesById(int id, Fields fields) {
        return gameApi.getGamesById(id, fields.toString())
                .flatMap(gameObjs -> Observable.just(TransformUtil.transformCollection(gameObjs)));
    }

    /**
     * то же, что {@link #searchGames(String, Fields, int, int, Order)}, но для движков
     */
    public Observable<ArrayList<GameEngine>> searchGameEngines(String searchQuery, Fields fields, int limit, int offset, Order order) {
        return gameApi.searchForGameEngines(fields.toString(), limit, offset, order.toString(), searchQuery)
                .flatMap(gameEngineObjs -> Observable.just(TransformUtil.transformCollection(gameEngineObjs)));
    }

    /**
     * то же, что и {@link #searchGames(String, Fields, int, int, Order, Filter)}, но для движков
     */
    public Observable<ArrayList<GameEngine>> searchGameEngines(String searchQuery,
                                                               Fields fields,
                                                               int limit,
                                                               int offset,
                                                               Order order,
                                                               Filter filter) {
        return gameApi.searchForGameEngines(fields.toString(), limit, offset, order.toString(), searchQuery, filter.toMap())
                .flatMap(gameEngineObjs -> Observable.just(TransformUtil.transformCollection(gameEngineObjs)));
    }

    public Observable<ArrayList<GameEngine>> searchGameEngines(Query query) {
        return searchGameEngines(
                query.getSearchQuery(),
                query.getFields(),
                query.getLimit(),
                query.getOffset(),
                query.getOrder(),
                query.getFilter());
    }

    /**
     * то же, что и {@link #getGamesById(int, Fields)}, но для для движков
     */
    public Observable<ArrayList<GameEngine>> getGameEnginesById(int id, Fields fields) {
        return gameApi.getGameEnginesById(id, fields.toString())
                .flatMap(gameEngineObjs -> Observable.just(TransformUtil.transformCollection(gameEngineObjs)));
    }

    /**
     * то же, что {@link #searchGames(String, Fields, int, int, Order)}, но для игровых режимов
     */
    public Observable<ArrayList<GameMode>> searchGameModes(String searchQuery, Fields fields, int limit, int offset, Order order) {
        return gameApi.searchForGameModes(fields.toString(), limit, offset, order.toString(), searchQuery)
                .flatMap(gameModeObjs -> Observable.just(TransformUtil.transformCollection(gameModeObjs)));
    }

    /**
     * то же, что и {@link #searchGames(String, Fields, int, int, Order, Filter)}, но для игровых режимов
     */
    public Observable<ArrayList<GameMode>> searchGameModes(String searchQuery,
                                                           Fields fields,
                                                           int limit,
                                                           int offset,
                                                           Order order,
                                                           Filter filter) {
        return gameApi.searchForGameModes(fields.toString(), limit, offset, order.toString(), searchQuery, filter.toMap())
                .flatMap(gameModeObjs -> Observable.just(TransformUtil.transformCollection(gameModeObjs)));
    }

    public Observable<ArrayList<GameMode>> searchGameModes(Query query) {
        return searchGameModes(
                query.getSearchQuery(),
                query.getFields(),
                query.getLimit(),
                query.getOffset(),
                query.getOrder(),
                query.getFilter());
    }

    /**
     * то же, что и {@link #getGamesById(int, Fields)}, но для игровых режимов
     */
    public Observable<ArrayList<GameMode>> getGameModesById(int id, Fields fields) {
        return gameApi.getGameModesById(id, fields.toString())
                .flatMap(gameModeObjs -> Observable.just(TransformUtil.transformCollection(gameModeObjs)));
    }
}
