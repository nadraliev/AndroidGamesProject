package com.soutvoid.gamesproject.interactor.company;

import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.domain.company.Company;
import com.soutvoid.gamesproject.interactor.company.network.CompanyApi;
import com.soutvoid.gamesproject.interactor.util.Filter;
import com.soutvoid.gamesproject.interactor.util.TransformUtil;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observable;


@PerApplication
public class CompanyRepository {

    CompanyApi companyApi;

    @Inject
    public CompanyRepository(CompanyApi companyApi) {
        this.companyApi = companyApi;
    }

    public Observable<ArrayList<Company>> searchCompanies(String searchQuery, String fields, int limit, int offset, String order) {
        return companyApi.searchForCompanies(fields, limit, offset, order, searchQuery)
                .flatMap(companyObjs -> Observable.just(TransformUtil.transformCollection(companyObjs)));
    }

    public Observable<ArrayList<Company>> searchCompanies(String searchQuery,
                                                          String fields,
                                                          int limit,
                                                          int offset,
                                                          String order,
                                                          Filter filter) {
        return companyApi.searchForCompanies(fields, limit, offset, order, searchQuery, filter.toMap())
                .flatMap(companyObjs -> Observable.just(TransformUtil.transformCollection(companyObjs)));
    }

    public Observable<ArrayList<Company>> getCompaniesById(int id, String fields) {
        return companyApi.getCompaniesById(id, fields)
                .flatMap(companyObjs -> Observable.just(TransformUtil.transformCollection(companyObjs)));
    }
}
