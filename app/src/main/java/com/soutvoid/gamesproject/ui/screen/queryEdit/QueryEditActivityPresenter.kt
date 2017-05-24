package com.soutvoid.gamesproject.ui.screen.queryEdit

import android.widget.CompoundButton
import com.agna.ferro.mvp.component.scope.PerScreen
import com.soutvoid.gamesproject.domain.game.fields.GameFields
import com.soutvoid.gamesproject.domain.genre.Genre
import com.soutvoid.gamesproject.interactor.genre.GenreRepository
import com.soutvoid.gamesproject.interactor.util.*
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter
import com.soutvoid.gamesproject.ui.common.error.ErrorHandler
import com.soutvoid.gamesproject.ui.screen.queryEdit.data.QueryData
import com.soutvoid.gamesproject.ui.util.CalendarUtils
import io.realm.Realm
import rx.functions.Action1
import javax.inject.Inject

@PerScreen
class QueryEditActivityPresenter @Inject
constructor(errorHandler: ErrorHandler,
            private val genreRepository: GenreRepository) : BasePresenter<QueryEditActivityView>(errorHandler) {

    private var realm: Realm? = null
    private var genres: List<Genre>? = null

    override fun onLoad(viewRecreated: Boolean) {
        super.onLoad(viewRecreated)

        genres = genresFromDb
        updateGenresDBIfNeeded()
        updateGenresScreenData()
    }

    private fun updateGenresDBIfNeeded() {
        realm = Realm.getDefaultInstance()

//        subscribeNetworkQuery<ArrayList<Genre>>(
//                genreRepository.searchGenres(
//                        null!!,
//                        Fields.builder().build(),
//                        50,
//                        0,
//                        Order.builder().build()
//                ),
//                { genresFromNet : List<Genre> ->
//                    if (genres != genresFromNet) {
//                        realm!!.executeTransaction { realm1 ->
//                            realm1.delete(Genre::class.java)
//                            realm1.copyToRealm<Genre>(genresFromNet)
//                        }
//                        genres = genresFromNet
//                        updateGenresScreenData()
//                    }
//                    realm!!.close()
//                },
//                { t : Throwable -> realm!!.close() }
//        )

        subscribeNetworkQuery(
                genreRepository.searchGenres(
                        null,
                        Fields.builder().build(),
                        50,
                        0,
                        Order.builder().build()
                ),
                Action1 { genresFromNet: ArrayList<Genre> ->
                    if (genres != genresFromNet) {
                        realm!!.executeTransaction { realm1 ->
                            realm1.delete(Genre::class.java)
                            realm1.copyToRealm<Genre>(genresFromNet)
                        }
                        genres = genresFromNet
                        updateGenresScreenData()
                    }
                    realm!!.close()
                },
                Action1 { t: Throwable -> realm!!.close() }
        )
    }

    private val genresFromDb: List<Genre>
        get() {
            realm = Realm.getDefaultInstance()
            val genres = realm!!.copyFromRealm(realm!!.where(Genre::class.java).findAll())
            realm!!.close()
            return genres
        }

    private fun updateGenresScreenData() {
        view.setGenresList(genres!!)
    }

    internal fun onSaveClick() {
        gatherAndSaveQuery()
        view.finish()
    }

    @Synchronized private fun gatherAndSaveQuery() {
        realm = Realm.getDefaultInstance()

        // increment index
        val nextId = realm!!.where(ExploreQuery::class.java).count().toInt()

        val data = view.data

        val filter = buildFilterFromData(data)

        val query = Query(null,
                Fields.builder().build(),
                20,
                0,
                Order.builder().field(GameFields.POPULARITY.toString()).build(),
                filter
        )
        val exploreQuery = ExploreQuery(
                nextId,
                data.name,
                query
        )

        realm!!.executeTransaction { realm1 -> realm1.copyToRealm(exploreQuery) }
        realm!!.close()
    }

    internal fun buildFilterFromData(data: QueryData): Filter {
        val comparsion = CalendarUtils.compareCalendarDays(data.releasedFrom, data.releasedTo)

        val from = if (comparsion > 0) data.releasedTo else data.releasedFrom
        val to = if (comparsion > 0) data.releasedFrom else data.releasedTo

        val filter = Filter()

        //add release dates
        filter.add(
                GameFields.FIRST_RELEASE_DATE.toString(),
                Filter.Factor.gt.toString(),
                CalendarUtils.getCalendarDayInMillis(from).toString())

        if (view.isReleasedToIncluded)
            filter.add(
                    GameFields.FIRST_RELEASE_DATE.toString(),
                    Filter.Factor.lt.toString(),
                    CalendarUtils.getCalendarDayInMillis(to).toString())

        //add genres
        if (data.selectedGenres != null && data.selectedGenres.size > 0) {
            val genresStr = data.selectedGenres
                    .map { genres!![it].id.toString() }
                    .joinToString(",")
            filter.add(
                    GameFields.GENRES.toString(),
                    Filter.Factor.`in`.toString(),
                    genresStr
            )
        }

        return filter
    }

    internal fun onReleasedIncludeToClicked(button: CompoundButton, isChecked: Boolean) {
        view.toggleReleasedToDatePicker(isChecked)
    }
}
