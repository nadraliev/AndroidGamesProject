package com.soutvoid.gamesproject.interactor.platform.network;

import com.soutvoid.gamesproject.interactor.platform.network.response.PlatformObj;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

import static com.soutvoid.gamesproject.interactor.common.network.ServerUrls.PLATFORMS_URL;

public interface PlatformApi {

    @GET(PLATFORMS_URL)
    Observable<ArrayList<PlatformObj>> searchForPlatforms(@Query("fields") String fields,
                                                          @Query("limit") int limit,
                                                          @Query("offset") int offset,
                                                          @Query("order") String order,
                                                          @Query("search") String searchQuery);

    @GET(PLATFORMS_URL)
    Observable<ArrayList<PlatformObj>> searchForPlatforms(@Query("fields") String fields,
                                                          @Query("limit") int limit,
                                                          @Query("offset") int offset,
                                                          @Query("order") String order,
                                                          @Query("search") String searchQuery,
                                                          @QueryMap Map<String, String> filters);

    @GET(PLATFORMS_URL + "{id}")
    Observable<ArrayList<PlatformObj>> getPlatformsById(@Path("id") int id,
                                                        @Query("fields") String fields);

}
