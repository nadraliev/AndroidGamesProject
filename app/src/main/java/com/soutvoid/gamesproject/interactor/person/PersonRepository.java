package com.soutvoid.gamesproject.interactor.person;

import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.domain.person.Person;
import com.soutvoid.gamesproject.interactor.person.network.PersonApi;
import com.soutvoid.gamesproject.interactor.util.Fields;
import com.soutvoid.gamesproject.interactor.util.Filter;
import com.soutvoid.gamesproject.interactor.util.Order;
import com.soutvoid.gamesproject.interactor.util.TransformUtil;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observable;

@PerApplication
public class PersonRepository {

    private PersonApi personApi;

    @Inject
    public PersonRepository(PersonApi personApi) {
        this.personApi = personApi;
    }

    /**
     * поиск людей
     *
     * @param searchQuery поисковой запрос
     * @param fields      поля, которые необходимо включить в ответ. стрится с помощью {@link Fields}
     * @param limit       лимит кол-ва результатов
     * @param offset      пагинация ответа
     * @param order       сортировка. стрится с помощью {@link Order}
     * @return список людей
     */
    public Observable<ArrayList<Person>> searchPeople(String searchQuery, Fields fields, int limit, int offset, Order order) {
        return personApi.searchForPeople(fields.toString(), limit, offset, order.toString(), searchQuery)
                .flatMap(personObjs -> Observable.just(TransformUtil.transformCollection(personObjs)));
    }

    /**
     * то же, что {@link #searchPeople(String, Fields, int, int, Order)}, но с фильтром
     *
     * @param filter объект с фильтрами
     *                (ключ - параметры фильтрования, значение - собственно, значение, относительно которого сортировать)
     *                строится с помощью {@link Filter}
     */
    public Observable<ArrayList<Person>> searchPeople(String searchQuery,
                                                      Fields fields,
                                                      int limit,
                                                      int offset,
                                                      Order order,
                                                      Filter filter) {
        return personApi.searchForPeople(fields.toString(), limit, offset, order.toString(), searchQuery, filter.toMap())
                .flatMap(personObjs -> Observable.just(TransformUtil.transformCollection(personObjs)));
    }

    /**
     * получение человека по id
     *
     * @param id
     * @param fields поля, включенные в ответ
     * @return массив. обычно состоящий из одного человека
     */
    public Observable<ArrayList<Person>> getPeopleById(int id, Fields fields) {
        return personApi.getPeopleById(id, fields.toString())
                .flatMap(personObjs -> Observable.just(TransformUtil.transformCollection(personObjs)));
    }
}
