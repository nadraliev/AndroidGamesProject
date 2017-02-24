package com.soutvoid.gamesproject.interactor.keyword.network;

import com.soutvoid.gamesproject.interactor.keyword.network.response.KeywordObj;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

import static com.soutvoid.gamesproject.interactor.common.network.ServerUrls.KEYWORDS_URL;

public interface KeywordApi {

    @GET(KEYWORDS_URL)
    Observable<ArrayList<KeywordObj>> searchForKeywords(@Query("fields") String fields,
                                                        @Query("limit") int limit,
                                                        @Query("offset") int offset,
                                                        @Query("order") String order,
                                                        @Query("search") String searchQuery);

    @GET(KEYWORDS_URL)
    Observable<ArrayList<KeywordObj>> searchForKeywords(@Query("fields") String fields,
                                                        @Query("limit") int limit,
                                                        @Query("offset") int offset,
                                                        @Query("order") String order,
                                                        @Query("search") String searchQuery,
                                                        @QueryMap Map<String, String> filters);

    @GET(KEYWORDS_URL + "{id}")
    Observable<ArrayList<KeywordObj>> getKeywordsById(@Path("id") int id,
                                                      @Query("fields") String fields);

}
