package com.soutvoid.gamesproject.interactor.franchise

import com.agna.ferro.mvp.component.scope.PerApplication
import com.soutvoid.gamesproject.domain.franchise.Franchise
import com.soutvoid.gamesproject.interactor.franchise.network.FranchiseApi
import com.soutvoid.gamesproject.interactor.franchise.network.response.FranchiseObj
import com.soutvoid.gamesproject.interactor.util.*
import rx.Observable
import java.util.*
import javax.inject.Inject


@PerApplication
class FranchiseRepository @Inject
constructor(private val franchiseApi: FranchiseApi) {

    fun searchFranchises(searchQuery: String?, fields: Fields?, limit: Int, offset: Int, order: Order?): Observable<ArrayList<Franchise>> {
        return franchiseApi.searchForFranchises(fields.toString(), limit, offset, order.toString(), searchQuery)
                .flatMap { franchiseObjs -> Observable.just(TransformUtil.transformCollection<Franchise, FranchiseObj>(franchiseObjs)) }
    }

    fun searchFranchises(searchQuery: String?,
                         fields: Fields?,
                         limit: Int,
                         offset: Int,
                         order: Order?,
                         filter: Filter?): Observable<ArrayList<Franchise>> {
        return franchiseApi.searchForFranchises(fields.toString(), limit, offset, order.toString(), searchQuery, filter?.toMap())
                .flatMap { franchiseObjs -> Observable.just(TransformUtil.transformCollection<Franchise, FranchiseObj>(franchiseObjs)) }
    }

    fun getFranchisesById(id: Int, fields: Fields?): Observable<ArrayList<Franchise>> {
        return franchiseApi.getFranchisesById(id, fields.toString())
                .flatMap { franchiseObjs -> Observable.just(TransformUtil.transformCollection<Franchise, FranchiseObj>(franchiseObjs)) }
    }

    fun searchFranchises(query: Query): Observable<ArrayList<Franchise>> {
        return searchFranchises(
                query.searchQuery,
                query.fields,
                query.limit,
                query.offset,
                query.order,
                query.filter)
    }

}
