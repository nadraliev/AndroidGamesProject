package com.soutvoid.gamesproject.interactor.game.network;

import com.soutvoid.gamesproject.interactor.game.network.response.GameObj;

import java.util.ArrayList;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

import static com.soutvoid.gamesproject.interactor.common.network.ServerUrls.GAMES_URL;

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

    @GET(GAMES_URL + "{id}")
    Observable<ArrayList<GameObj>> getGamesById(@Path("id") int id,
                                                @Query("fields") String fields);

}
