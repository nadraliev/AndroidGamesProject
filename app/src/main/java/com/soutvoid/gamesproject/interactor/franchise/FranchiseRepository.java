package com.soutvoid.gamesproject.interactor.franchise;

import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.domain.franchise.Franchise;
import com.soutvoid.gamesproject.interactor.franchise.network.FranchiseApi;
import com.soutvoid.gamesproject.interactor.util.Fields;
import com.soutvoid.gamesproject.interactor.util.Filter;
import com.soutvoid.gamesproject.interactor.util.Order;
import com.soutvoid.gamesproject.interactor.util.TransformUtil;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observable;


@PerApplication
public class FranchiseRepository {

    private FranchiseApi franchiseApi;

    @Inject
    public FranchiseRepository(FranchiseApi franchiseApi) {
        this.franchiseApi = franchiseApi;
    }

    public Observable<ArrayList<Franchise>> searchFranchises(String searchQuery, Fields fields, int limit, int offset, Order order) {
        return franchiseApi.searchForFranchises(fields.toString(), limit, offset, order.toString(), searchQuery)
                .flatMap(franchiseObjs -> Observable.just(TransformUtil.transformCollection(franchiseObjs)));
    }

    public Observable<ArrayList<Franchise>> searchFranchises(String searchQuery,
                                                             Fields fields,
                                                             int limit,
                                                             int offset,
                                                             Order order,
                                                             Filter filter) {
        return franchiseApi.searchForFranchises(fields.toString(), limit, offset, order.toString(), searchQuery, filter.toMap())
                .flatMap(franchiseObjs -> Observable.just(TransformUtil.transformCollection(franchiseObjs)));
    }

    public Observable<ArrayList<Franchise>> getFranchisesById(int id, Fields fields) {
        return franchiseApi.getFranchisesById(id, fields.toString())
                .flatMap(franchiseObjs -> Observable.just(TransformUtil.transformCollection(franchiseObjs)));
    }

}
