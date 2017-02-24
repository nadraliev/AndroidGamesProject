package com.soutvoid.gamesproject.interactor.person.network;

import com.soutvoid.gamesproject.interactor.person.network.response.PersonObj;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

import static com.soutvoid.gamesproject.interactor.common.network.ServerUrls.PEOPLE_URL;

public interface PersonApi {

    @GET(PEOPLE_URL)
    Observable<ArrayList<PersonObj>> searchForPeople(@Query("fields") String fields,
                                                     @Query("limit") int limit,
                                                     @Query("offset") int offset,
                                                     @Query("order") String order,
                                                     @Query("search") String searchQuery);

    @GET(PEOPLE_URL)
    Observable<ArrayList<PersonObj>> searchForPeople(@Query("fields") String fields,
                                                     @Query("limit") int limit,
                                                     @Query("offset") int offset,
                                                     @Query("order") String order,
                                                     @Query("search") String searchQuery,
                                                     @QueryMap Map<String, String> filters);

    @GET(PEOPLE_URL + "{id}")
    Observable<ArrayList<PersonObj>> getPeopleById(@Path("id") int id,
                                                   @Query("fields") String fields);

}
