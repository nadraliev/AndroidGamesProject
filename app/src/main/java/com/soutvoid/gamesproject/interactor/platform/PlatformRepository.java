package com.soutvoid.gamesproject.interactor.platform;

import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.domain.platform.Platform;
import com.soutvoid.gamesproject.interactor.platform.network.PlatformApi;
import com.soutvoid.gamesproject.interactor.util.Fields;
import com.soutvoid.gamesproject.interactor.util.Filter;
import com.soutvoid.gamesproject.interactor.util.Order;
import com.soutvoid.gamesproject.interactor.util.Query;
import com.soutvoid.gamesproject.interactor.util.TransformUtil;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observable;

@PerApplication
public class PlatformRepository {

    private PlatformApi platformApi;

    @Inject
    public PlatformRepository(PlatformApi platformApi) {
        this.platformApi = platformApi;
    }

    /**
     * поиск платформ
     *
     * @param searchQuery поисковой запрос
     * @param fields      поля, которые необходимо включить в ответ. стрится с помощью {@link Fields}
     * @param limit       лимит кол-ва результатов
     * @param offset      пагинация ответа
     * @param order       сортировка. стрится с помощью {@link Order}
     * @return список платформ
     */
    public Observable<ArrayList<Platform>> searchPlatforms(String searchQuery, Fields fields, int limit, int offset, Order order) {
        return platformApi.searchForPlatforms(fields.toString(), limit, offset, order.toString(), searchQuery)
                .flatMap(platformObjs -> Observable.just(TransformUtil.transformCollection(platformObjs)));
    }

    /**
     * то же, что {@link #searchPlatforms(String, Fields, int, int, Order)}, но с фильтром
     *
     * @param filter объект с фильтрами
     *                (ключ - параметры фильтрования, значение - собственно, значение, относительно которого сортировать)
     *                строится с помощью {@link Filter}
     */
    public Observable<ArrayList<Platform>> searchPlatforms(String searchQuery,
                                                           Fields fields,
                                                           int limit,
                                                           int offset,
                                                           Order order,
                                                           Filter filter) {
        return platformApi.searchForPlatforms(fields.toString(), limit, offset, order.toString(), searchQuery, filter.toMap())
                .flatMap(platformObjs -> Observable.just(TransformUtil.transformCollection(platformObjs)));
    }

    public Observable<ArrayList<Platform>> searchPlatforms(Query query) {
        return searchPlatforms(
                query.getSearchQuery(),
                query.getFields(),
                query.getLimit(),
                query.getOffset(),
                query.getOrder(),
                query.getFilter());
    }

    /**
     * получение платформы по id
     *
     * @param id
     * @param fields поля, включенные в ответ
     * @return массив. обычно состоящий из одной платформы
     */
    public Observable<ArrayList<Platform>> getPlatformsById(int id, Fields fields) {
        return platformApi.getPlatformsById(id, fields.toString())
                .flatMap(platformObjs -> Observable.just(TransformUtil.transformCollection(platformObjs)));
    }
}
