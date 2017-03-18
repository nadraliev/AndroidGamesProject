package com.soutvoid.gamesproject.interactor.genre;

import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.domain.genre.Genre;
import com.soutvoid.gamesproject.interactor.genre.network.GenreApi;
import com.soutvoid.gamesproject.interactor.util.FieldsBuilder;
import com.soutvoid.gamesproject.interactor.util.FilterBuilder;
import com.soutvoid.gamesproject.interactor.util.OrderBuilder;
import com.soutvoid.gamesproject.interactor.util.TransformUtil;

import java.util.ArrayList;
import java.util.Map;

import javax.inject.Inject;

import rx.Observable;

@PerApplication
public class GenreRepository {

    private GenreApi genreApi;

    @Inject
    public GenreRepository(GenreApi genreApi) {
        this.genreApi = genreApi;
    }

    /**
     * поиск жанров
     *
     * @param searchQuery поисковой запрос
     * @param fields      поля, которые необходимо включить в ответ. стрится с помощью {@link FieldsBuilder}
     * @param limit       лимит кол-ва результатов
     * @param offset      пагинация ответа
     * @param order       сортировка. стрится с помощью {@link OrderBuilder}
     * @return список жанров
     */
    public Observable<ArrayList<Genre>> searchGenres(String searchQuery, String fields, int limit, int offset, String order) {
        return genreApi.searchForGenres(fields, limit, offset, order, searchQuery)
                .flatMap(genreObjs -> Observable.just(TransformUtil.transformCollection(genreObjs)));
    }

    /**
     * то же, что {@link #searchGenres(String, String, int, int, String)}, но с фильтром
     *
     * @param filters map с фильтрами
     *                (ключ - параметры фильтрования, значение - собственно, значение, относительно которого сортировать)
     *                строится с помощью {@link FilterBuilder}
     */
    public Observable<ArrayList<Genre>> searchGenres(String searchQuery,
                                                     String fields,
                                                     int limit,
                                                     int offset,
                                                     String order,
                                                     Map<String, String> filters) {
        return genreApi.searchForGenres(fields, limit, offset, order, searchQuery, filters)
                .flatMap(genreObjs -> Observable.just(TransformUtil.transformCollection(genreObjs)));
    }

    /**
     * получение жанра по id
     *
     * @param id
     * @param fields поля, включенные в ответ
     * @return массив. обычно состоящий из одного жанра
     */
    public Observable<ArrayList<Genre>> getGenresById(int id, String fields) {
        return genreApi.getGenresById(id, fields)
                .flatMap(genreObjs -> Observable.just(TransformUtil.transformCollection(genreObjs)));
    }
}
