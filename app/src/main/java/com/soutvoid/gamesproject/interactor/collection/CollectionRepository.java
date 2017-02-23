package com.soutvoid.gamesproject.interactor.collection;


import com.soutvoid.gamesproject.domain.collection.Collection;
import com.soutvoid.gamesproject.interactor.collection.network.CollectionApi;
import com.soutvoid.gamesproject.interactor.util.TransformUtil;

import java.util.ArrayList;
import java.util.Map;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CollectionRepository {

    CollectionApi collectionApi;

    @Inject
    public CollectionRepository(CollectionApi collectionApi) {
        this.collectionApi = collectionApi;
    }

    public Observable<ArrayList<Collection>> searchCollections(String searchQuery, String fields, int limit, int offset, String order) {
        return collectionApi.searchCollections(fields, limit, offset, order, searchQuery)
                .flatMap(collectionObjs -> Observable.just(TransformUtil.transformCollection(collectionObjs)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ArrayList<Collection>> searchCollections(String searchQuery,
                                                               String fields,
                                                               int limit,
                                                               int offset,
                                                               String order,
                                                               Map<String, String> filters) {
        return collectionApi.searchCollections(fields, limit, offset, order, searchQuery, filters)
                .flatMap(collectionObjs -> Observable.just(TransformUtil.transformCollection(collectionObjs)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ArrayList<Collection>> getCollectionsById(int id, String fields) {
        return collectionApi.getCollectionsById(id, fields)
                .flatMap(collectionObjs -> Observable.just(TransformUtil.transformCollection(collectionObjs)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
