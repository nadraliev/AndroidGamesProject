package com.soutvoid.gamesproject.interactor.keyword;

import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.domain.keyword.Keyword;
import com.soutvoid.gamesproject.interactor.keyword.network.KeywordApi;
import com.soutvoid.gamesproject.interactor.util.Fields;
import com.soutvoid.gamesproject.interactor.util.Filter;
import com.soutvoid.gamesproject.interactor.util.Order;
import com.soutvoid.gamesproject.interactor.util.TransformUtil;

import java.util.ArrayList;

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
     * @param fields      поля, которые необходимо включить в ответ. стрится с помощью {@link Fields}
     * @param limit       лимит кол-ва результатов
     * @param offset      пагинация ответа
     * @param order       сортировка. стрится с помощью {@link Order}
     * @return список ключевых слов
     */
    public Observable<ArrayList<Keyword>> searchKeywords(String searchQuery, Fields fields, int limit, int offset, Order order) {
        return keywordApi.searchForKeywords(fields.toString(), limit, offset, order.toString(), searchQuery)
                .flatMap(keywordObjs -> Observable.just(TransformUtil.transformCollection(keywordObjs)));
    }

    /**
     * то же, что {@link #searchKeywords(String, Fields, int, int, Order)}, но с фильтром
     *
     * @param filter объект с фильтрами
     *                (ключ - параметры фильтрования, значение - собственно, значение, относительно которого сортировать)
     *                строится с помощью {@link Filter}
     */
    public Observable<ArrayList<Keyword>> searchKeywords(String searchQuery,
                                                         Fields fields,
                                                         int limit,
                                                         int offset,
                                                         Order order,
                                                         Filter filter) {
        return keywordApi.searchForKeywords(fields.toString(), limit, offset, order.toString(), searchQuery, filter.toMap())
                .flatMap(keywordObjs -> Observable.just(TransformUtil.transformCollection(keywordObjs)));
    }

    /**
     * получение ключевого слова по id
     *
     * @param id
     * @param fields поля, включенные в ответ
     * @return массив. обычно состоящий из одного ключевого слова
     */
    public Observable<ArrayList<Keyword>> getKeywordsById(int id, Fields fields) {
        return keywordApi.getKeywordsById(id, fields.toString())
                .flatMap(keywordObjs -> Observable.just(TransformUtil.transformCollection(keywordObjs)));
    }
}
