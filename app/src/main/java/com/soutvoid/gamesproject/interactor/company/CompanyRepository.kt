package com.soutvoid.gamesproject.interactor.company

import com.agna.ferro.mvp.component.scope.PerApplication
import com.soutvoid.gamesproject.domain.company.Company
import com.soutvoid.gamesproject.interactor.company.network.CompanyApi
import com.soutvoid.gamesproject.interactor.company.network.response.CompanyObj
import com.soutvoid.gamesproject.interactor.util.*
import rx.Observable
import java.util.*
import javax.inject.Inject


@PerApplication
class CompanyRepository @Inject
constructor(internal var companyApi: CompanyApi) {

    fun searchCompanies(searchQuery: String?, fields: Fields?, limit: Int, offset: Int, order: Order?): Observable<ArrayList<Company>> {
        return companyApi.searchForCompanies(fields.toString(), limit, offset, order.toString(), searchQuery)
                .flatMap { companyObjs -> Observable.just(TransformUtil.transformCollection<Company, CompanyObj>(companyObjs)) }
    }

    fun searchCompanies(searchQuery: String?,
                        fields: Fields?,
                        limit: Int,
                        offset: Int,
                        order: Order?,
                        filter: Filter?): Observable<ArrayList<Company>> {
        return companyApi.searchForCompanies(fields.toString(), limit, offset, order.toString(), searchQuery, filter?.toMap())
                .flatMap { companyObjs -> Observable.just(TransformUtil.transformCollection<Company, CompanyObj>(companyObjs)) }
    }

    fun getCompaniesById(id: Int, fields: Fields?): Observable<ArrayList<Company>> {
        return companyApi.getCompaniesById(id, fields.toString())
                .flatMap { companyObjs -> Observable.just(TransformUtil.transformCollection<Company, CompanyObj>(companyObjs)) }
    }

    fun searchCompanies(query: Query): Observable<ArrayList<Company>> {
        return searchCompanies(
                query.searchQuery,
                query.fields,
                query.limit,
                query.offset,
                query.order,
                query.filter)
    }
}
