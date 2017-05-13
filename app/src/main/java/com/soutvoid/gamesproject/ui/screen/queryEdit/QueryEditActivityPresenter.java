package com.soutvoid.gamesproject.ui.screen.queryEdit;

import com.agna.ferro.mvp.component.scope.PerScreen;
import com.soutvoid.gamesproject.domain.game.fields.GameFields;
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

import java.util.Calendar;

import javax.inject.Inject;

import io.realm.Realm;

@PerScreen
public class QueryEditActivityPresenter extends BasePresenter<QueryEditActivityView> {

    Realm realm;

    @Inject
    public QueryEditActivityPresenter(ErrorHandler errorHandler) {
        super(errorHandler);
    }

    @Override
    public void onLoad(boolean viewRecreated) {
        super.onLoad(viewRecreated);

        updateReleasedFromScreen(Calendar.getInstance());
        updateReleasedToScreen(Calendar.getInstance());
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

        int comparsion = CalendarUtils.compareCalendarDays(data.getReleasedFrom(), data.getReleasedTo());

        MonthAdapter.CalendarDay from = comparsion > 0 ? data.getReleasedTo() : data.getReleasedFrom();
        MonthAdapter.CalendarDay to = comparsion > 0 ? data.getReleasedFrom() : data.getReleasedTo();

        Filter filter = Filter.builder()
                .field(GameFields.FIRST_RELEASE_DATE.toString())
                .factor(Filter.Factor.gt.toString())
                .value(String.valueOf(CalendarUtils.getCalendarDayInMillis(from)))
                .field(GameFields.FIRST_RELEASE_DATE.toString())
                .factor(Filter.Factor.lt.toString())
                .value(String.valueOf(CalendarUtils.getCalendarDayInMillis(to)))
                .build();

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

    void onFromDatePicked(int year, int monthOfYear, int dayOfMonth) {
        updateReleasedFromScreen(year, monthOfYear, dayOfMonth);
    }

    private void updateReleasedFromScreen(int year, int monthOfYear, int dayOfMonth) {
        getView().setReleasedFromText(year, monthOfYear, dayOfMonth);
    }

    private void updateReleasedFromScreen(Calendar calendar) {
        getView().setReleasedFromText(calendar);
    }

    void onToDatePicked(int year, int monthOfYear, int dayOfMonth) {
        updateReleasedToScreen(year, monthOfYear, dayOfMonth);
    }

    private void updateReleasedToScreen(int year, int monthOfYear, int dayOfMonth) {
        getView().setReleasedToText(year, monthOfYear, dayOfMonth);
    }

    private void updateReleasedToScreen(Calendar calendar) {
        getView().setReleasedToText(calendar);
    }
}
