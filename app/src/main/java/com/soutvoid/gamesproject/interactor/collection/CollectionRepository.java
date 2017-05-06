package com.soutvoid.gamesproject.interactor.collection;


import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.domain.collection.Collection;
import com.soutvoid.gamesproject.interactor.collection.network.CollectionApi;
import com.soutvoid.gamesproject.interactor.util.Fields;
import com.soutvoid.gamesproject.interactor.util.Filter;
import com.soutvoid.gamesproject.interactor.util.Order;
import com.soutvoid.gamesproject.interactor.util.TransformUtil;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observable;

@PerApplication
public class CollectionRepository {

    CollectionApi collectionApi;

    @Inject
    public CollectionRepository(CollectionApi collectionApi) {
        this.collectionApi = collectionApi;
    }

    public Observable<ArrayList<Collection>> searchCollections(String searchQuery, Fields fields, int limit, int offset, Order order) {
        return collectionApi.searchCollections(fields.toString(), limit, offset, order.toString(), searchQuery)
                .flatMap(collectionObjs -> Observable.just(TransformUtil.transformCollection(collectionObjs)));
    }

    public Observable<ArrayList<Collection>> searchCollections(String searchQuery,
                                                               Fields fields,
                                                               int limit,
                                                               int offset,
                                                               Order order,
                                                               Filter filter) {
        return collectionApi.searchCollections(fields.toString(), limit, offset, order.toString(), searchQuery, filter.toMap())
                .flatMap(collectionObjs -> Observable.just(TransformUtil.transformCollection(collectionObjs)));
    }

    public Observable<ArrayList<Collection>> getCollectionsById(int id, Fields fields) {
        return collectionApi.getCollectionsById(id, fields.toString())
                .flatMap(collectionObjs -> Observable.just(TransformUtil.transformCollection(collectionObjs)));
    }
}
