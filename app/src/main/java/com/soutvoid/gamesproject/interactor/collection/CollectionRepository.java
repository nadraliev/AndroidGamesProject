package com.soutvoid.gamesproject.interactor.collection;


import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.domain.collection.Collection;
import com.soutvoid.gamesproject.interactor.collection.network.CollectionApi;
import com.soutvoid.gamesproject.interactor.util.TransformUtil;

import java.util.ArrayList;
import java.util.Map;

import javax.inject.Inject;

import rx.Observable;

@PerApplication
public class CollectionRepository {

    CollectionApi collectionApi;

    @Inject
    public CollectionRepository(CollectionApi collectionApi) {
        this.collectionApi = collectionApi;
    }

    public Observable<ArrayList<Collection>> searchCollections(String searchQuery, String fields, int limit, int offset, String order) {
        return collectionApi.searchCollections(fields, limit, offset, order, searchQuery)
                .flatMap(collectionObjs -> Observable.just(TransformUtil.transformCollection(collectionObjs)));
    }

    public Observable<ArrayList<Collection>> searchCollections(String searchQuery,
                                                               String fields,
                                                               int limit,
                                                               int offset,
                                                               String order,
                                                               Map<String, String> filters) {
        return collectionApi.searchCollections(fields, limit, offset, order, searchQuery, filters)
                .flatMap(collectionObjs -> Observable.just(TransformUtil.transformCollection(collectionObjs)));
    }

    public Observable<ArrayList<Collection>> getCollectionsById(int id, String fields) {
        return collectionApi.getCollectionsById(id, fields)
                .flatMap(collectionObjs -> Observable.just(TransformUtil.transformCollection(collectionObjs)));
    }
}
