package com.soutvoid.gamesproject.ui.screen.main;

import com.agna.ferro.mvp.component.scope.PerScreen;
import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.soutvoid.gamesproject.domain.game.fields.GameFields;
import com.soutvoid.gamesproject.interactor.game.GameRepository;
import com.soutvoid.gamesproject.interactor.util.ExploreQuery;
import com.soutvoid.gamesproject.interactor.util.Fields;
import com.soutvoid.gamesproject.interactor.util.Filter;
import com.soutvoid.gamesproject.interactor.util.ObservableUtil;
import com.soutvoid.gamesproject.interactor.util.Order;
import com.soutvoid.gamesproject.interactor.util.Query;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.common.error.ErrorHandler;
import com.soutvoid.gamesproject.ui.screen.main.data.ExploreSetData;
import com.soutvoid.gamesproject.ui.screen.main.data.ExploreSets;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import rx.Observable;
import rx.schedulers.Schedulers;


@PerScreen
public class MainActivityPresenter extends BasePresenter<MainActivityView> {

    private GameRepository gameRepository;
    private Realm realm;

    @Inject
    public MainActivityPresenter(ErrorHandler errorHandler,
                                 GameRepository gameRepository) {
        super(errorHandler);
        this.gameRepository = gameRepository;
    }


    @Override
    public void onLoad(boolean viewRecreated) {
        super.onLoad(viewRecreated);

        //main showcase query
        Query query = new Query(
                null,
                Fields.builder().build(),
                20,
                0,
                Order.builder().field(GameFields.POPULARITY.toString()).build(),
                Filter.builder().field(GameFields.FIRST_RELEASE_DATE.toString()).factor(Filter.Factor.gt.toString()).value("1483228800000").build()
        );

        subscribeNetworkQuery(gameRepository.searchGames(query),
                games -> getView().onSetShowcaseViewGames(games));
    }

    @Override
    public void onResume() {
        super.onResume();

        refreshExploreSets();
    }

    private synchronized void refreshExploreSets() {
        getView().onDeleteAllExploreSets();
        realm = Realm.getDefaultInstance();
        List<ExploreQuery> exploreQueries = realm.copyFromRealm(realm.where(ExploreQuery.class).findAll());
        realm.close();
        List<Observable<?>> sources = Stream.of(exploreQueries).map(
                exploreQuery ->
                        Observable.zip(
                                Observable.just(exploreQuery.getPosition()),
                                Observable.just(exploreQuery.getName()),
                                gameRepository.searchGames(exploreQuery.getQuery()),
                                ExploreSetData::new
                        )
        ).collect(Collectors.toList());
        Observable<ExploreSets> responses = ObservableUtil.combineLatestDelayError(
                Schedulers.io(),
                sources,
                ExploreSets::new
        );
        subscribeNetworkQuery(responses,
                data -> getView().onShowExploreSetsData(data));
    }
}
