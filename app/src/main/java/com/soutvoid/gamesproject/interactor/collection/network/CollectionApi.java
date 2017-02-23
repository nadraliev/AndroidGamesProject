package com.soutvoid.gamesproject.interactor.collection.network;

import com.soutvoid.gamesproject.interactor.collection.network.response.CollectionObj;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

import static com.soutvoid.gamesproject.interactor.common.network.ServerUrls.COLLECTIONS_URL;

/**
 * Created by andrew on 2/23/17.
 */

public interface CollectionApi {

    @GET(COLLECTIONS_URL + "{id}")
    Observable<ArrayList<CollectionObj>> getCollectionsById(@Path("id") int id,
                                                            @Query("fields") String fields);

    @GET(COLLECTIONS_URL)
    Observable<ArrayList<CollectionObj>> searchCollections(@Query("fields") String fields,
                                                           @Query("limit") int limit,
                                                           @Query("offset") int offset,
                                                           @Query("order") String order,
                                                           @Query("search") String searchQuery);

    @GET(COLLECTIONS_URL)
    Observable<ArrayList<CollectionObj>> searchCollectionsWithFilters(@Query("fields") String fields,
                                                                      @Query("limit") int limit,
                                                                      @Query("offset") int offset,
                                                                      @Query("order") String order,
                                                                      @Query("search") String searchQuery,
                                                                      @QueryMap Map<String, String> filters);
}
