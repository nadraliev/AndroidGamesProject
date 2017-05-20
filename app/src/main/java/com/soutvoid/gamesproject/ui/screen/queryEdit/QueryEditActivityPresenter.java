package com.soutvoid.gamesproject.ui.screen.queryEdit;

import android.widget.CompoundButton;

import com.agna.ferro.mvp.component.scope.PerScreen;
import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.soutvoid.gamesproject.domain.game.fields.GameFields;
import com.soutvoid.gamesproject.domain.genre.Genre;
import com.soutvoid.gamesproject.interactor.genre.GenreRepository;
import com.soutvoid.gamesproject.interactor.util.ExploreQuery;
import com.soutvoid.gamesproject.interactor.util.Fields;
import com.soutvoid.gamesproject.interactor.util.Filter;
import com.soutvoid.gamesproject.interactor.util.Order;
import com.soutvoid.gamesproject.interactor.util.Query;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.common.error.ErrorHandler;
import com.soutvoid.gamesproject.ui.screen.queryEdit.data.QueryData;
import com.soutvoid.gamesproject.ui.util.CalendarUtils;
import com.wdullaer.materialdatetimepicker.date.MonthAdapter;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import rx.Observable;

@PerScreen
public class QueryEditActivityPresenter extends BasePresenter<QueryEditActivityView> {

    private Realm realm;
    private GenreRepository genreRepository;
    private List<Genre> genres;

    @Inject
    public QueryEditActivityPresenter(ErrorHandler errorHandler,
                                      GenreRepository genreRepository) {
        super(errorHandler);
        this.genreRepository = genreRepository;
    }

    @Override
    public void onLoad(boolean viewRecreated) {
        super.onLoad(viewRecreated);

        subscribeNetworkQuery(
                getGenresFromDb(),
                genres1 -> {
                    genres = genres1;
                    updateGenresDBIfNeeded();
                    updateGenresScreenData();
                }
        );

    }

    private void updateGenresDBIfNeeded() {
        realm = Realm.getDefaultInstance();

        subscribeNetworkQuery(
                genreRepository.searchGenres(
                        null,
                        Fields.builder().build(),
                        50,
                        0,
                        Order.builder().build()
                ),
                genresFromNet -> {
                    if (!genres.equals(genresFromNet))
                        realm.executeTransaction(
                                realm1 -> {
                                    realm1.delete(Genre.class);
                                    realm1.copyToRealm(genresFromNet);
                                });
                    realm.close();
                },
                t -> realm.close()
        );
    }

    private Observable<List<Genre>> getGenresFromDb() {
        realm = Realm.getDefaultInstance();
        List<Genre> genres = realm.copyFromRealm(realm.where(Genre.class).findAll());
        realm.close();
        return Observable.just(genres);
    }

    private void updateGenresScreenData() {
        getView().setGenresList(genres);
    }

    void onSaveClick() {
        gatherAndSaveQuery();
        getView().finish();
    }

    private synchronized void gatherAndSaveQuery() {
        realm = Realm.getDefaultInstance();

        // increment index
        int nextId = (int) (realm.where(ExploreQuery.class).count());

        QueryData data = getView().getData();

        Filter filter = buildFilterFromData(data);

        Query query = new Query(
                null,
                Fields.builder().build(),
                20,
                0,
                Order.builder().field(GameFields.POPULARITY.toString()).build(),
                filter
        );
        ExploreQuery exploreQuery = new ExploreQuery(
                nextId,
                data.getName(),
                query
        );

        realm.executeTransaction(realm1 -> realm1.copyToRealm(exploreQuery));
        realm.close();
    }

    Filter buildFilterFromData(QueryData data) {
        int comparsion = CalendarUtils.compareCalendarDays(data.getReleasedFrom(), data.getReleasedTo());

        MonthAdapter.CalendarDay from = comparsion > 0 ? data.getReleasedTo() : data.getReleasedFrom();
        MonthAdapter.CalendarDay to = comparsion > 0 ? data.getReleasedFrom() : data.getReleasedTo();

        Filter filter = new Filter();

        //add release dates
        filter.add(
                GameFields.FIRST_RELEASE_DATE.toString(),
                Filter.Factor.gt.toString(),
                String.valueOf(CalendarUtils.getCalendarDayInMillis(from)));

        if (getView().isReleasedToIncluded())
            filter.add(
                    GameFields.FIRST_RELEASE_DATE.toString(),
                    Filter.Factor.lt.toString(),
                    String.valueOf(CalendarUtils.getCalendarDayInMillis(to)));

        //add genres
        if (data.getSelectedGenres() != null && data.getSelectedGenres().size() > 0) {
            String genresStr = Stream.of(data.getSelectedGenres())
                    .map(index -> String.valueOf(genres.get(index).getId()))
                    .collect(Collectors.joining(","));
            filter.add(
                    GameFields.GENRES.toString(),
                    Filter.Factor.in.toString(),
                    genresStr
            );
        }

        return filter;
    }

    void onReleasedIncludeToClicked(CompoundButton button, boolean isChecked) {
        getView().toggleReleasedToDatePicker(isChecked);
    }
}
