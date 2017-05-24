package com.soutvoid.gamesproject.interactor.game

import com.agna.ferro.mvp.component.scope.PerApplication
import com.soutvoid.gamesproject.domain.game.Game
import com.soutvoid.gamesproject.domain.game.GameEngine
import com.soutvoid.gamesproject.domain.game.GameMode
import com.soutvoid.gamesproject.interactor.game.network.GameApi
import com.soutvoid.gamesproject.interactor.game.network.response.GameEngineObj
import com.soutvoid.gamesproject.interactor.game.network.response.GameModeObj
import com.soutvoid.gamesproject.interactor.game.network.response.GameObj
import com.soutvoid.gamesproject.interactor.network.connection.NetworkConnectionChecker
import com.soutvoid.gamesproject.interactor.util.*
import rx.Observable
import java.util.*
import javax.inject.Inject

@PerApplication
class GameRepository @Inject
constructor(private val gameApi: GameApi, private val networkConnectionChecker: NetworkConnectionChecker) {

    /**
     * поиск игр

     * @param searchQuery поисковой запрос
     * *
     * @param fields      поля, которые необходимо включить в ответ. стрится с помощью [Fields]
     * *
     * @param limit       лимит кол-ва результатов
     * *
     * @param offset      пагинация ответа
     * *
     * @param order       сортировка. стрится с помощью [Order]
     * *
     * @return список игр
     */
    fun searchGames(searchQuery: String?, fields: Fields?, limit: Int, offset: Int, order: Order?): Observable<ArrayList<Game>> {
        return gameApi.searchForGames(fields.toString(), limit, offset, order.toString(), searchQuery)
                .flatMap { gameObjs -> Observable.just(TransformUtil.transformCollection<Game, GameObj>(gameObjs)) }
    }

    /**
     * то же, что [.searchGames], но с фильтром
     * @param filter  объект с фильтрами
     * *                (ключ - параметры фильтрования, значение - собственно, значение, относительно которого сортировать)
     * *                строится с помощью [Filter]
     */
    fun searchGames(searchQuery: String?,
                    fields: Fields?,
                    limit: Int,
                    offset: Int,
                    order: Order?,
                    filter: Filter?): Observable<ArrayList<Game>> {
        return gameApi.searchForGames(fields.toString(), limit, offset, order.toString(), searchQuery, filter?.toMap())
                .flatMap { gameObjs -> Observable.just(TransformUtil.transformCollection<Game, GameObj>(gameObjs)) }
    }

    fun searchGames(query: Query): Observable<ArrayList<Game>> {
        return searchGames(
                query.searchQuery,
                query.fields,
                query.limit,
                query.offset,
                query.order,
                query.filter)
    }

    /**
     * получение игры по id
     * @param id
     * *
     * @param fields поля, включенные в ответ
     * *
     * @return массив. обычно состоящий из одной игры
     */
    fun getGamesById(id: Int, fields: Fields): Observable<ArrayList<Game>> {
        return gameApi.getGamesById(id, fields.toString())
                .flatMap { gameObjs -> Observable.just(TransformUtil.transformCollection<Game, GameObj>(gameObjs)) }
    }

    /**
     * то же, что [.searchGames], но для движков
     */
    fun searchGameEngines(searchQuery: String?, fields: Fields?, limit: Int, offset: Int, order: Order?): Observable<ArrayList<GameEngine>> {
        return gameApi.searchForGameEngines(fields.toString(), limit, offset, order.toString(), searchQuery)
                .flatMap { gameEngineObjs -> Observable.just(TransformUtil.transformCollection<GameEngine, GameEngineObj>(gameEngineObjs)) }
    }

    /**
     * то же, что и [.searchGames], но для движков
     */
    fun searchGameEngines(searchQuery: String?,
                          fields: Fields?,
                          limit: Int,
                          offset: Int,
                          order: Order?,
                          filter: Filter?): Observable<ArrayList<GameEngine>> {
        return gameApi.searchForGameEngines(fields.toString(), limit, offset, order.toString(), searchQuery, filter?.toMap())
                .flatMap { gameEngineObjs -> Observable.just(TransformUtil.transformCollection<GameEngine, GameEngineObj>(gameEngineObjs)) }
    }

    fun searchGameEngines(query: Query): Observable<ArrayList<GameEngine>> {
        return searchGameEngines(
                query.searchQuery,
                query.fields,
                query.limit,
                query.offset,
                query.order,
                query.filter)
    }

    /**
     * то же, что и [.getGamesById], но для для движков
     */
    fun getGameEnginesById(id: Int, fields: Fields): Observable<ArrayList<GameEngine>> {
        return gameApi.getGameEnginesById(id, fields.toString())
                .flatMap { gameEngineObjs -> Observable.just(TransformUtil.transformCollection<GameEngine, GameEngineObj>(gameEngineObjs)) }
    }

    /**
     * то же, что [.searchGames], но для игровых режимов
     */
    fun searchGameModes(searchQuery: String?, fields: Fields?, limit: Int, offset: Int, order: Order?): Observable<ArrayList<GameMode>> {
        return gameApi.searchForGameModes(fields.toString(), limit, offset, order.toString(), searchQuery)
                .flatMap { gameModeObjs -> Observable.just(TransformUtil.transformCollection<GameMode, GameModeObj>(gameModeObjs)) }
    }

    /**
     * то же, что и [.searchGames], но для игровых режимов
     */
    fun searchGameModes(searchQuery: String?,
                        fields: Fields?,
                        limit: Int,
                        offset: Int,
                        order: Order?,
                        filter: Filter?): Observable<ArrayList<GameMode>> {
        return gameApi.searchForGameModes(fields.toString(), limit, offset, order.toString(), searchQuery, filter?.toMap())
                .flatMap { gameModeObjs -> Observable.just(TransformUtil.transformCollection<GameMode, GameModeObj>(gameModeObjs)) }
    }

    fun searchGameModes(query: Query): Observable<ArrayList<GameMode>> {
        return searchGameModes(
                query.searchQuery,
                query.fields,
                query.limit,
                query.offset,
                query.order,
                query.filter)
    }

    /**
     * то же, что и [.getGamesById], но для игровых режимов
     */
    fun getGameModesById(id: Int, fields: Fields): Observable<ArrayList<GameMode>> {
        return gameApi.getGameModesById(id, fields.toString())
                .flatMap { gameModeObjs -> Observable.just(TransformUtil.transformCollection<GameMode, GameModeObj>(gameModeObjs)) }
    }
}
