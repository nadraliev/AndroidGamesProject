package com.soutvoid.gamesproject.interactor.person;

import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.domain.person.Person;
import com.soutvoid.gamesproject.interactor.person.network.PersonApi;
import com.soutvoid.gamesproject.interactor.util.FieldsBuilder;
import com.soutvoid.gamesproject.interactor.util.FilterBuilder;
import com.soutvoid.gamesproject.interactor.util.OrderBuilder;
import com.soutvoid.gamesproject.interactor.util.TransformUtil;

import java.util.ArrayList;
import java.util.Map;

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
     * @param fields      поля, которые необходимо включить в ответ. стрится с помощью {@link FieldsBuilder}
     * @param limit       лимит кол-ва результатов
     * @param offset      пагинация ответа
     * @param order       сортировка. стрится с помощью {@link OrderBuilder}
     * @return список людей
     */
    public Observable<ArrayList<Person>> searchPeople(String searchQuery, String fields, int limit, int offset, String order) {
        return personApi.searchForPeople(fields, limit, offset, order, searchQuery)
                .flatMap(personObjs -> Observable.just(TransformUtil.transformCollection(personObjs)));
    }

    /**
     * то же, что {@link #searchPeople(String, String, int, int, String)}, но с фильтром
     *
     * @param filters map с фильтрами
     *                (ключ - параметры фильтрования, значение - собственно, значение, относительно которого сортировать)
     *                строится с помощью {@link FilterBuilder}
     */
    public Observable<ArrayList<Person>> searchPeople(String searchQuery,
                                                      String fields,
                                                      int limit,
                                                      int offset,
                                                      String order,
                                                      Map<String, String> filters) {
        return personApi.searchForPeople(fields, limit, offset, order, searchQuery, filters)
                .flatMap(personObjs -> Observable.just(TransformUtil.transformCollection(personObjs)));
    }

    /**
     * получение человека по id
     *
     * @param id
     * @param fields поля, включенные в ответ
     * @return массив. обычно состоящий из одного человека
     */
    public Observable<ArrayList<Person>> getPeopleById(int id, String fields) {
        return personApi.getPeopleById(id, fields)
                .flatMap(personObjs -> Observable.just(TransformUtil.transformCollection(personObjs)));
    }
}
