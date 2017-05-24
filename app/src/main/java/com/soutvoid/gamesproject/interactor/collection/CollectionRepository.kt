package com.soutvoid.gamesproject.interactor.collection


import com.agna.ferro.mvp.component.scope.PerApplication
import com.soutvoid.gamesproject.domain.collection.Collection
import com.soutvoid.gamesproject.interactor.collection.network.CollectionApi
import com.soutvoid.gamesproject.interactor.collection.network.response.CollectionObj
import com.soutvoid.gamesproject.interactor.util.*
import rx.Observable
import java.util.*
import javax.inject.Inject

@PerApplication
class CollectionRepository @Inject
constructor(internal var collectionApi: CollectionApi) {

    fun searchCollections(searchQuery: String?, fields: Fields?, limit: Int, offset: Int, order: Order?): Observable<ArrayList<Collection>> {
        return collectionApi.searchCollections(fields.toString(), limit, offset, order.toString(), searchQuery)
                .flatMap { collectionObjs -> Observable.just(TransformUtil.transformCollection<Collection, CollectionObj>(collectionObjs)) }
    }

    fun searchCollections(searchQuery: String?,
                          fields: Fields?,
                          limit: Int,
                          offset: Int,
                          order: Order?,
                          filter: Filter?): Observable<ArrayList<Collection>> {
        return collectionApi.searchCollections(fields.toString(), limit, offset, order.toString(), searchQuery, filter?.toMap())
                .flatMap { collectionObjs -> Observable.just(TransformUtil.transformCollection<Collection, CollectionObj>(collectionObjs)) }
    }

    fun getCollectionsById(id: Int, fields: Fields?): Observable<ArrayList<Collection>> {
        return collectionApi.getCollectionsById(id, fields.toString())
                .flatMap { collectionObjs -> Observable.just(TransformUtil.transformCollection<Collection, CollectionObj>(collectionObjs)) }
    }

    fun searchCollections(query: Query): Observable<ArrayList<Collection>> {
        return searchCollections(
                query.searchQuery,
                query.fields,
                query.limit,
                query.offset,
                query.order,
                query.filter)
    }
}
