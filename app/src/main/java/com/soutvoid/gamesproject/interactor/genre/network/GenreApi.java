package com.soutvoid.gamesproject.interactor.genre.network;


import com.soutvoid.gamesproject.interactor.genre.network.response.GenreObj;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

import static com.soutvoid.gamesproject.interactor.common.network.ServerUrls.GENRES_URL;

public interface GenreApi {

    @GET(GENRES_URL)
    Observable<ArrayList<GenreObj>> searchForGenres(@Query("fields") String fields,
                                                    @Query("limit") int limit,
                                                    @Query("offset") int offset,
                                                    @Query("order") String order,
                                                    @Query("search") String searchQuery);

    @GET(GENRES_URL)
    Observable<ArrayList<GenreObj>> searchForGenres(@Query("fields") String fields,
                                                    @Query("limit") int limit,
                                                    @Query("offset") int offset,
                                                    @Query("order") String order,
                                                    @Query("search") String searchQuery,
                                                    @QueryMap Map<String, String> filters);

    @GET(GENRES_URL + "{id}")
    Observable<ArrayList<GenreObj>> getGenresById(@Path("id") int id,
                                                  @Query("fields") String fields);

}
