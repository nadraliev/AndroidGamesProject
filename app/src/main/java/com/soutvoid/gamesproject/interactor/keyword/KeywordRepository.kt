package com.soutvoid.gamesproject.interactor.keyword

import com.agna.ferro.mvp.component.scope.PerApplication
import com.soutvoid.gamesproject.domain.keyword.Keyword
import com.soutvoid.gamesproject.interactor.keyword.network.KeywordApi
import com.soutvoid.gamesproject.interactor.keyword.network.response.KeywordObj
import com.soutvoid.gamesproject.interactor.util.*
import rx.Observable
import java.util.*
import javax.inject.Inject

@PerApplication
class KeywordRepository @Inject
constructor(private val keywordApi: KeywordApi) {

    /**
     * поиск ключевых слов

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
     * @return список ключевых слов
     */
    fun searchKeywords(searchQuery: String?, fields: Fields?, limit: Int, offset: Int, order: Order?): Observable<ArrayList<Keyword>> {
        return keywordApi.searchForKeywords(fields.toString(), limit, offset, order.toString(), searchQuery)
                .flatMap { keywordObjs -> Observable.just(TransformUtil.transformCollection<Keyword, KeywordObj>(keywordObjs)) }
    }

    /**
     * то же, что [.searchKeywords], но с фильтром

     * @param filter объект с фильтрами
     * *                (ключ - параметры фильтрования, значение - собственно, значение, относительно которого сортировать)
     * *                строится с помощью [Filter]
     */
    fun searchKeywords(searchQuery: String?,
                       fields: Fields?,
                       limit: Int,
                       offset: Int,
                       order: Order?,
                       filter: Filter?): Observable<ArrayList<Keyword>> {
        return keywordApi.searchForKeywords(fields.toString(), limit, offset, order.toString(), searchQuery, filter?.toMap())
                .flatMap { keywordObjs -> Observable.just(TransformUtil.transformCollection<Keyword, KeywordObj>(keywordObjs)) }
    }

    fun searchKeywords(query: Query): Observable<ArrayList<Keyword>> {
        return searchKeywords(
                query.searchQuery,
                query.fields,
                query.limit,
                query.offset,
                query.order,
                query.filter)
    }

    /**
     * получение ключевого слова по id

     * @param id
     * *
     * @param fields поля, включенные в ответ
     * *
     * @return массив. обычно состоящий из одного ключевого слова
     */
    fun getKeywordsById(id: Int, fields: Fields): Observable<ArrayList<Keyword>> {
        return keywordApi.getKeywordsById(id, fields.toString())
                .flatMap { keywordObjs -> Observable.just(TransformUtil.transformCollection<Keyword, KeywordObj>(keywordObjs)) }
    }
}
