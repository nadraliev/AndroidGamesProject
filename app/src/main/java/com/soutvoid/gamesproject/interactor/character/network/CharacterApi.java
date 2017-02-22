package com.soutvoid.gamesproject.interactor.character.network;

import com.soutvoid.gamesproject.domain.character.Character;
import com.soutvoid.gamesproject.interactor.character.network.response.CharacterObj;
import com.soutvoid.gamesproject.interactor.game.network.response.GameObj;

import java.util.ArrayList;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

import static com.soutvoid.gamesproject.interactor.common.network.ServerConstants.API_KEY;
import static com.soutvoid.gamesproject.interactor.common.network.ServerConstants.KEY_API_KEY;
import static com.soutvoid.gamesproject.interactor.common.network.ServerUrls.CHARACTERS_URL;
import static com.soutvoid.gamesproject.interactor.common.network.ServerUrls.GAMES_URL;

/**
 * Created by andrew on 22-Feb-17.
 */

public interface CharacterApi {

    @GET(CHARACTERS_URL + "{id}")
    @Headers(KEY_API_KEY + ": " + API_KEY)
    Observable<ArrayList<CharacterObj>> getCharactersById(@Path("id") int characterId);

    @GET(CHARACTERS_URL)
    @Headers(KEY_API_KEY + ": " + API_KEY)
    Observable<ArrayList<CharacterObj>> searchForCharacters(@Query("fields") String fields,
                                                  @Query("limit") int limit,
                                                  @Query("offset") int offset,
                                                  @Query("order") String order,
                                                  @Query("search") String searchQuery);

}
