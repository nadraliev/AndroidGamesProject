package com.soutvoid.gamesproject.interactor.platform

import com.agna.ferro.mvp.component.scope.PerApplication
import com.soutvoid.gamesproject.domain.platform.Platform
import com.soutvoid.gamesproject.interactor.platform.network.PlatformApi
import com.soutvoid.gamesproject.interactor.platform.network.response.PlatformObj
import com.soutvoid.gamesproject.interactor.util.*
import rx.Observable
import java.util.*
import javax.inject.Inject

@PerApplication
class PlatformRepository @Inject
constructor(private val platformApi: PlatformApi) {

    /**
     * поиск платформ

     * @param searchQuery поисковой запрос
     * *
     * @param fields      поля, которые необходимо включить в ответ. стрится с помощью [Fields]
     * *
     * @param limit       лимит кол-ва результатов
     * *
     * @param offset      пагинация ответа
     * *
     * @param order       сортировка. стрится с помощью [Order]
     * *
     * @return список платформ
     */
    fun searchPlatforms(searchQuery: String?, fields: Fields?, limit: Int, offset: Int, order: Order?): Observable<ArrayList<Platform>> {
        return platformApi.searchForPlatforms(fields.toString(), limit, offset, order.toString(), searchQuery)
                .flatMap { platformObjs -> Observable.just(TransformUtil.transformCollection<Platform, PlatformObj>(platformObjs)) }
    }

    /**
     * то же, что [.searchPlatforms], но с фильтром

     * @param filter объект с фильтрами
     * *                (ключ - параметры фильтрования, значение - собственно, значение, относительно которого сортировать)
     * *                строится с помощью [Filter]
     */
    fun searchPlatforms(searchQuery: String?,
                        fields: Fields?,
                        limit: Int,
                        offset: Int,
                        order: Order?,
                        filter: Filter?): Observable<ArrayList<Platform>> {
        return platformApi.searchForPlatforms(fields.toString(), limit, offset, order.toString(), searchQuery, filter?.toMap())
                .flatMap { platformObjs -> Observable.just(TransformUtil.transformCollection<Platform, PlatformObj>(platformObjs)) }
    }

    fun searchPlatforms(query: Query): Observable<ArrayList<Platform>> {
        return searchPlatforms(
                query.searchQuery,
                query.fields,
                query.limit,
                query.offset,
                query.order,
                query.filter)
    }

    /**
     * получение платформы по id

     * @param id
     * *
     * @param fields поля, включенные в ответ
     * *
     * @return массив. обычно состоящий из одной платформы
     */
    fun getPlatformsById(id: Int, fields: Fields): Observable<ArrayList<Platform>> {
        return platformApi.getPlatformsById(id, fields.toString())
                .flatMap { platformObjs -> Observable.just(TransformUtil.transformCollection<Platform, PlatformObj>(platformObjs)) }
    }
}
