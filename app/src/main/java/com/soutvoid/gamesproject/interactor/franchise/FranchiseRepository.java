package com.soutvoid.gamesproject.interactor.franchise;

import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.domain.franchise.Franchise;
import com.soutvoid.gamesproject.interactor.franchise.network.FranchiseApi;
import com.soutvoid.gamesproject.interactor.util.TransformUtil;

import java.util.ArrayList;
import java.util.Map;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by andrew on 2/23/17.
 */

@PerApplication
public class FranchiseRepository {

    private FranchiseApi franchiseApi;

    @Inject
    public FranchiseRepository(FranchiseApi franchiseApi) {
        this.franchiseApi = franchiseApi;
    }

    public Observable<ArrayList<Franchise>> searchFranchises(String searchQuery, String fields, int limit, int offset, String order) {
        return franchiseApi.searchForFranchises(fields, limit, offset, order, searchQuery)
                .flatMap(franchiseObjs -> Observable.just(TransformUtil.transformCollection(franchiseObjs)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ArrayList<Franchise>> searchFranchises(String searchQuery,
                                                             String fields,
                                                             int limit,
                                                             int offset,
                                                             String order,
                                                             Map<String, String> filters) {
        return franchiseApi.searchForFranchises(fields, limit, offset, order, searchQuery, filters)
                .flatMap(franchiseObjs -> Observable.just(TransformUtil.transformCollection(franchiseObjs)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ArrayList<Franchise>> getFranchisesById(int id, String fields) {
        return franchiseApi.getFranchisesById(id, fields)
                .flatMap(franchiseObjs -> Observable.just(TransformUtil.transformCollection(franchiseObjs)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
