package com.soutvoid.gamesproject.interactor.company.network;

import com.soutvoid.gamesproject.interactor.company.network.response.CompanyObj;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

import static com.soutvoid.gamesproject.interactor.common.network.ServerUrls.COMPANIES_URL;

/**
 * Created by andrew on 2/23/17.
 */

public interface CompanyApi {

    @GET(COMPANIES_URL)
    Observable<ArrayList<CompanyObj>> searchForCompanies(@Query("fields") String fields,
                                                         @Query("limit") int limit,
                                                         @Query("offset") int offset,
                                                         @Query("order") String order,
                                                         @Query("search") String searchQuery);

    @GET(COMPANIES_URL)
    Observable<ArrayList<CompanyObj>> searchForCompanies(@Query("fields") String fields,
                                                         @Query("limit") int limit,
                                                         @Query("offset") int offset,
                                                         @Query("order") String order,
                                                         @Query("search") String searchQuery,
                                                         @QueryMap Map<String, String> filters);

    @GET(COMPANIES_URL + "{id}")
    Observable<ArrayList<CompanyObj>> getCompaniesById(@Path("id") int id,
                                                       @Query("fields") String fields);


}
