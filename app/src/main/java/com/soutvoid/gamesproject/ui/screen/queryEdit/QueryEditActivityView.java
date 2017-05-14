package com.soutvoid.gamesproject.ui.screen.queryEdit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.agna.ferro.mvp.component.ScreenComponent;
import com.soutvoid.gamesproject.ui.base.activity.BaseActivityView;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.base.widgets.IgdbToolbar;
import com.soutvoid.gamesproject.ui.screen.queryEdit.data.QueryData;
import com.soutvoid.gamesproject.ui.screen.queryEdit.widgets.choosableDate.ChoosableDateTextView;
import com.wdullaer.materialdatetimepicker.date.MonthAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import soutvoid.com.gamesproject.R;

public class QueryEditActivityView extends BaseActivityView {

    @BindView(R.id.toolbar)
    IgdbToolbar toolbar;
    @BindView(R.id.section_released_from)
    ChoosableDateTextView releasedFrom;
    @BindView(R.id.section_released_to)
    ChoosableDateTextView releasedTo;

    @Inject
    QueryEditActivityPresenter presenter;

    public static void start(Context context) {
        Intent intent = new Intent(context, QueryEditActivityView.class);
        context.startActivity(intent);
    }

    @Override
    public BasePresenter getPresenter() {
        return presenter;
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_query_edit;
    }

    @Override
    protected ScreenComponent createScreenComponent() {
        return DaggerQueryEditActivityComponent.builder()
                .activityModule(getActivityModule())
                .appComponent(getAppComponent())
                .build();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState, boolean viewRecreated) {
        super.onCreate(savedInstanceState, viewRecreated);

        setupToolbar();
        setupDatePickers();
    }

    private void setupToolbar() {
        toolbar.showExpandedPurpleToolbarSaveInput(
                getString(R.string.new_query),
                this,
                v -> presenter.onSaveClick());
    }

    private void setupDatePickers() {
        releasedFrom.setActivity(this);
        releasedTo.setActivity(this);
    }


    String getNameInput() {
        return toolbar.getInputText();
    }

    void setNameInput(String input) {
        toolbar.setInputText(input);
    }

    MonthAdapter.CalendarDay getReleasedFromDate() {
        return releasedFrom.getSelectedDay();
    }

    MonthAdapter.CalendarDay getReleasedToDate() {
        return releasedTo.getSelectedDay();
    }

    QueryData getData() {
        return new QueryData(
                getNameInput(),
                getReleasedFromDate(),
                getReleasedToDate()
        );
    }
}
