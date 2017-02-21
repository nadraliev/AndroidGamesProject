package com.soutvoid.gamesproject.interactor.game.network;

import com.soutvoid.gamesproject.interactor.game.network.response.GamesResponse;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

import static com.soutvoid.gamesproject.interactor.common.network.ServerConstants.API_KEY;
import static com.soutvoid.gamesproject.interactor.common.network.ServerUrls.GAMES_URL;

/**
 * Created by andrew on 2/21/17.
 */

public interface GameApi {

    @GET(GAMES_URL)
    @Headers(API_KEY)
    Observable<GamesResponse> searchForGames(@Query("fields") String fields,
                                             @Query("limit") int limit,
                                             @Query("offset") int offset,
                                             @Query("order") String order,
                                             @Query("search") String searchQuery);

}
