package com.soutvoid.gamesproject.interactor.keyword;

import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.domain.keyword.Keyword;
import com.soutvoid.gamesproject.interactor.keyword.network.KeywordApi;
import com.soutvoid.gamesproject.interactor.util.FieldsBuilder;
import com.soutvoid.gamesproject.interactor.util.FilterBuilder;
import com.soutvoid.gamesproject.interactor.util.OrderBuilder;
import com.soutvoid.gamesproject.interactor.util.TransformUtil;

import java.util.ArrayList;
import java.util.Map;

import javax.inject.Inject;

import rx.Observable;

@PerApplication
public class KeywordRepository {

    private KeywordApi keywordApi;

    @Inject
    public KeywordRepository(KeywordApi keywordApi) {
        this.keywordApi = keywordApi;
    }

    /**
     * поиск ключевых слов
     *
     * @param searchQuery поисковой запрос
     * @param fields      поля, которые необходимо включить в ответ. стрится с помощью {@link FieldsBuilder}
     * @param limit       лимит кол-ва результатов
     * @param offset      пагинация ответа
     * @param order       сортировка. стрится с помощью {@link OrderBuilder}
     * @return список ключевых слов
     */
    public Observable<ArrayList<Keyword>> searchKeywords(String searchQuery, String fields, int limit, int offset, String order) {
        return keywordApi.searchForKeywords(fields, limit, offset, order, searchQuery)
                .flatMap(keywordObjs -> Observable.just(TransformUtil.transformCollection(keywordObjs)));
    }

    /**
     * то же, что {@link #searchKeywords(String, String, int, int, String)}, но с фильтром
     *
     * @param filters map с фильтрами
     *                (ключ - параметры фильтрования, значение - собственно, значение, относительно которого сортировать)
     *                строится с помощью {@link FilterBuilder}
     */
    public Observable<ArrayList<Keyword>> searchKeywords(String searchQuery,
                                                         String fields,
                                                         int limit,
                                                         int offset,
                                                         String order,
                                                         Map<String, String> filters) {
        return keywordApi.searchForKeywords(fields, limit, offset, order, searchQuery, filters)
                .flatMap(keywordObjs -> Observable.just(TransformUtil.transformCollection(keywordObjs)));
    }

    /**
     * получение ключевого слова по id
     *
     * @param id
     * @param fields поля, включенные в ответ
     * @return массив. обычно состоящий из одного ключевого слова
     */
    public Observable<ArrayList<Keyword>> getKeywordsById(int id, String fields) {
        return keywordApi.getKeywordsById(id, fields)
                .flatMap(keywordObjs -> Observable.just(TransformUtil.transformCollection(keywordObjs)));
    }
}
