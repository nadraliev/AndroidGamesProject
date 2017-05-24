package com.soutvoid.gamesproject.interactor.genre

import com.agna.ferro.mvp.component.scope.PerApplication
import com.soutvoid.gamesproject.domain.genre.Genre
import com.soutvoid.gamesproject.interactor.genre.network.GenreApi
import com.soutvoid.gamesproject.interactor.genre.network.response.GenreObj
import com.soutvoid.gamesproject.interactor.util.*
import rx.Observable
import java.util.*
import javax.inject.Inject

@PerApplication
class GenreRepository @Inject
constructor(private val genreApi: GenreApi) {

    /**
     * поиск жанров

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
     * @return список жанров
     */
    fun searchGenres(searchQuery: String?, fields: Fields?, limit: Int, offset: Int, order: Order?): Observable<ArrayList<Genre>> {
        return genreApi.searchForGenres(fields.toString(), limit, offset, order.toString(), searchQuery)
                .flatMap { genreObjs -> Observable.just(TransformUtil.transformCollection<Genre, GenreObj>(genreObjs)) }
    }

    /**
     * то же, что [.searchGenres], но с фильтром

     * @param filter объект с фильтрами
     * *                (ключ - параметры фильтрования, значение - собственно, значение, относительно которого сортировать)
     * *                строится с помощью [Filter]
     */
    fun searchGenres(searchQuery: String?,
                     fields: Fields?,
                     limit: Int,
                     offset: Int,
                     order: Order?,
                     filter: Filter?): Observable<ArrayList<Genre>> {
        return genreApi.searchForGenres(fields.toString(), limit, offset, order.toString(), searchQuery, filter?.toMap())
                .flatMap { genreObjs -> Observable.just(TransformUtil.transformCollection<Genre, GenreObj>(genreObjs)) }
    }

    fun searchGenres(query: Query): Observable<ArrayList<Genre>> {
        return searchGenres(
                query.searchQuery,
                query.fields,
                query.limit,
                query.offset,
                query.order,
                query.filter)
    }

    /**
     * получение жанра по id

     * @param id
     * *
     * @param fields поля, включенные в ответ
     * *
     * @return массив. обычно состоящий из одного жанра
     */
    fun getGenresById(id: Int, fields: Fields): Observable<ArrayList<Genre>> {
        return genreApi.getGenresById(id, fields.toString())
                .flatMap { genreObjs -> Observable.just(TransformUtil.transformCollection<Genre, GenreObj>(genreObjs)) }
    }
}
