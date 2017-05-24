package com.soutvoid.gamesproject.interactor.person

import com.agna.ferro.mvp.component.scope.PerApplication
import com.soutvoid.gamesproject.domain.person.Person
import com.soutvoid.gamesproject.interactor.person.network.PersonApi
import com.soutvoid.gamesproject.interactor.person.network.response.PersonObj
import com.soutvoid.gamesproject.interactor.util.*
import rx.Observable
import java.util.*
import javax.inject.Inject

@PerApplication
class PersonRepository @Inject
constructor(private val personApi: PersonApi) {

    /**
     * поиск людей

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
     * @return список людей
     */
    fun searchPeople(searchQuery: String?, fields: Fields?, limit: Int, offset: Int, order: Order?): Observable<ArrayList<Person>> {
        return personApi.searchForPeople(fields.toString(), limit, offset, order.toString(), searchQuery)
                .flatMap { personObjs -> Observable.just(TransformUtil.transformCollection<Person, PersonObj>(personObjs)) }
    }

    /**
     * то же, что [.searchPeople], но с фильтром

     * @param filter объект с фильтрами
     * *                (ключ - параметры фильтрования, значение - собственно, значение, относительно которого сортировать)
     * *                строится с помощью [Filter]
     */
    fun searchPeople(searchQuery: String?,
                     fields: Fields?,
                     limit: Int,
                     offset: Int,
                     order: Order?,
                     filter: Filter?): Observable<ArrayList<Person>> {
        return personApi.searchForPeople(fields.toString(), limit, offset, order.toString(), searchQuery, filter?.toMap())
                .flatMap { personObjs -> Observable.just(TransformUtil.transformCollection<Person, PersonObj>(personObjs)) }
    }

    fun searchPeople(query: Query): Observable<ArrayList<Person>> {
        return searchPeople(
                query.searchQuery,
                query.fields,
                query.limit,
                query.offset,
                query.order,
                query.filter)
    }

    /**
     * получение человека по id

     * @param id
     * *
     * @param fields поля, включенные в ответ
     * *
     * @return массив. обычно состоящий из одного человека
     */
    fun getPeopleById(id: Int, fields: Fields): Observable<ArrayList<Person>> {
        return personApi.getPeopleById(id, fields.toString())
                .flatMap { personObjs -> Observable.just(TransformUtil.transformCollection<Person, PersonObj>(personObjs)) }
    }
}
