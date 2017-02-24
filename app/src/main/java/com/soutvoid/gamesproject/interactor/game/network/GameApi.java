package com.soutvoid.gamesproject.interactor.game.network;

import com.soutvoid.gamesproject.interactor.game.network.response.GameEngineObj;
import com.soutvoid.gamesproject.interactor.game.network.response.GameModeObj;
import com.soutvoid.gamesproject.interactor.game.network.response.GameObj;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

import static com.soutvoid.gamesproject.interactor.common.network.ServerUrls.GAMES_URL;
import static com.soutvoid.gamesproject.interactor.common.network.ServerUrls.GAME_ENGINES_URL;
import static com.soutvoid.gamesproject.interactor.common.network.ServerUrls.GAME_MODES_URL;

/**
 * Created by andrew on 2/21/17.
 */

public interface GameApi {

    @GET(GAMES_URL)
    Observable<ArrayList<GameObj>> searchForGames(@Query("fields") String fields,
                                                  @Query("limit") int limit,
                                                  @Query("offset") int offset,
                                                  @Query("order") String order,
                                                  @Query("search") String searchQuery);

    @GET(GAMES_URL)
    Observable<ArrayList<GameObj>> searchForGames(@Query("fields") String fields,
                                                  @Query("limit") int limit,
                                                  @Query("offset") int offset,
                                                  @Query("order") String order,
                                                  @Query("search") String searchQuery,
                                                  @QueryMap Map<String, String> filters);

    @GET(GAMES_URL + "{id}")
    Observable<ArrayList<GameObj>> getGamesById(@Path("id") int id,
                                                @Query("fields") String fields);


    @GET(GAME_ENGINES_URL)
    Observable<ArrayList<GameEngineObj>> searchForGameEngines(@Query("fields") String fields,
                                                              @Query("limit") int limit,
                                                              @Query("offset") int offset,
                                                              @Query("order") String order,
                                                              @Query("search") String searchQuery);

    @GET(GAME_ENGINES_URL)
    Observable<ArrayList<GameEngineObj>> searchForGameEngines(@Query("fields") String fields,
                                                              @Query("limit") int limit,
                                                              @Query("offset") int offset,
                                                              @Query("order") String order,
                                                              @Query("search") String searchQuery,
                                                              @QueryMap Map<String, String> filters);

    @GET(GAME_ENGINES_URL + "{id}")
    Observable<ArrayList<GameEngineObj>> getGameEnginesById(@Path("id") int id,
                                                            @Query("fields") String fields);

    @GET(GAME_MODES_URL)
    Observable<ArrayList<GameModeObj>> searchForGameModes(@Query("fields") String fields,
                                                          @Query("limit") int limit,
                                                          @Query("offset") int offset,
                                                          @Query("order") String order,
                                                          @Query("search") String searchQuery);

    @GET(GAME_MODES_URL)
    Observable<ArrayList<GameModeObj>> searchForGameModes(@Query("fields") String fields,
                                                          @Query("limit") int limit,
                                                          @Query("offset") int offset,
                                                          @Query("order") String order,
                                                          @Query("search") String searchQuery,
                                                          @QueryMap Map<String, String> filters);

    @GET(GAME_MODES_URL + "{id}")
    Observable<ArrayList<GameModeObj>> getGameModesById(@Path("id") int id,
                                                            @Query("fields") String fields);
}
