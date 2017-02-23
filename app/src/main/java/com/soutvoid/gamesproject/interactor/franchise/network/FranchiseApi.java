package com.soutvoid.gamesproject.interactor.franchise.network;

import com.soutvoid.gamesproject.interactor.franchise.network.response.FranchiseObj;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

import static com.soutvoid.gamesproject.interactor.common.network.ServerUrls.FRANCHISES_URL;

/**
 * Created by andrew on 2/23/17.
 */

public interface FranchiseApi {

    @GET(FRANCHISES_URL)
    Observable<ArrayList<FranchiseObj>> searchForFranchises(@Query("fields") String fields,
                                                            @Query("limit") int limit,
                                                            @Query("offset") int offset,
                                                            @Query("order") String order,
                                                            @Query("search") String searchQuery);

    @GET(FRANCHISES_URL)
    Observable<ArrayList<FranchiseObj>> searchForFranchises(@Query("fields") String fields,
                                                            @Query("limit") int limit,
                                                            @Query("offset") int offset,
                                                            @Query("order") String order,
                                                            @Query("search") String searchQuery,
                                                            @QueryMap Map<String, String> filters);

    @GET(FRANCHISES_URL + "{id}")
    Observable<ArrayList<FranchiseObj>> getFranchisesById(@Path("id") int id,
                                                          @Query("fields") String fields);

}
