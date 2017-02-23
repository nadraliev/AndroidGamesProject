package com.soutvoid.gamesproject.interactor.character.network;

import com.soutvoid.gamesproject.interactor.character.network.response.CharacterObj;

import java.util.ArrayList;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

import static com.soutvoid.gamesproject.interactor.common.network.ServerUrls.CHARACTERS_URL;

/**
 * Created by andrew on 22-Feb-17.
 */

public interface CharacterApi {

    @GET(CHARACTERS_URL + "{id}")
    Observable<ArrayList<CharacterObj>> getCharactersById(@Path("id") int characterId,
                                                          @Query("fileds") String fields);

    @GET(CHARACTERS_URL)
    Observable<ArrayList<CharacterObj>> searchForCharacters(@Query("fields") String fields,
                                                  @Query("limit") int limit,
                                                  @Query("offset") int offset,
                                                  @Query("order") String order,
                                                  @Query("search") String searchQuery);

}
