package com.soutvoid.gamesproject.ui.screen.main

import com.agna.ferro.mvp.component.scope.PerScreen
import com.soutvoid.gamesproject.domain.game.Game
import com.soutvoid.gamesproject.domain.game.fields.GameFields
import com.soutvoid.gamesproject.interactor.game.GameRepository
import com.soutvoid.gamesproject.interactor.util.*
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter
import com.soutvoid.gamesproject.ui.common.error.ErrorHandler
import com.soutvoid.gamesproject.ui.screen.main.data.ExploreSetData
import com.soutvoid.gamesproject.ui.screen.main.data.ExploreSets
import io.realm.Realm
import rx.Observable
import rx.functions.Action1
import rx.schedulers.Schedulers
import java.util.*
import javax.inject.Inject


@PerScreen
class MainActivityPresenter @Inject
constructor(errorHandler: ErrorHandler,
            private val gameRepository: GameRepository) : BasePresenter<MainActivityView>(errorHandler) {
    private var realm: Realm? = null

    private var currentData: ExploreSets? = null


    override fun onLoad(viewRecreated: Boolean) {
        super.onLoad(viewRecreated)

        //main showcase query
        val query = Query(
                null,
                Fields.builder().build(),
                20,
                0,
                Order.builder().field(GameFields.POPULARITY.toString()).build(),
                Filter.builder().field(GameFields.FIRST_RELEASE_DATE.toString()).factor(Filter.Factor.gt.toString()).value("1483228800000")
                        .field(GameFields.FIRST_RELEASE_DATE.toString()).factor(Filter.Factor.lt.toString()).value(Calendar.getInstance().timeInMillis.toString())
                        .build()
        )

        subscribeNetworkQuery(gameRepository.searchGames(query)
                , Action1 { games: ArrayList<Game> -> view.onSetShowcaseViewGames(games) })

        if (viewRecreated && currentData != null)
            view.onShowExploreSetsData(currentData!!)
    }

    override fun onResume() {
        super.onResume()

        refreshExploreSets()
    }

    @Synchronized private fun refreshExploreSets() {
        realm = Realm.getDefaultInstance()
        val exploreQueries = realm!!.copyFromRealm(realm!!.where(ExploreQuery::class.java).findAll())
        realm!!.close()
        var sources = exploreQueries.mapIndexed { _, exploreQuery ->
            Observable.zip<Int, String, ArrayList<Game>, Any>(
                    Observable.just(exploreQuery.getPosition()),
                    Observable.just(exploreQuery.getName()),
                    gameRepository.searchGames(exploreQuery.getQuery()),
                    ::ExploreSetData
            )
        }
        val responses = ObservableUtil.combineLatestDelayError<Any, ExploreSets>(
                Schedulers.io(),
                sources,
                { ExploreSets(it) }
        )
        subscribeNetworkQuery(responses,
                Action1 { this.updateScreenData(it) })
    }

    @Synchronized private fun updateScreenData(exploreSets: ExploreSets) {
        if (currentData == null) {
            view.onDeleteAllExploreSets()
            currentData = exploreSets
            view.onShowExploreSetsData(exploreSets)
        } else {
            if (currentData != exploreSets) {
                view.onDeleteAllExploreSets()
                currentData = exploreSets
                view.onShowExploreSetsData(exploreSets)
            }
        }
    }

    internal fun onSearchClick() {

    }

    internal fun onListsClick() {

    }
}
