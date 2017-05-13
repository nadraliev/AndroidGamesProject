package com.soutvoid.gamesproject.ui.screen.queryEdit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.agna.ferro.mvp.component.ScreenComponent;
import com.soutvoid.gamesproject.ui.base.activity.BaseActivityView;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.base.widgets.IgdbToolbar;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.date.MonthAdapter;

import java.text.DateFormatSymbols;
import java.util.Calendar;

import javax.inject.Inject;

import butterknife.BindView;
import soutvoid.com.gamesproject.R;

public class QueryEditActivityView extends BaseActivityView {

    @BindView(R.id.toolbar)
    IgdbToolbar toolbar;
    @BindView(R.id.section_released_from)
    TextView releasedFrom;
    @BindView(R.id.section_released_to)
    TextView releasedTo;

    @Inject
    QueryEditActivityPresenter presenter;

    DatePickerDialog releasedFromDatePicker;
    DatePickerDialog releasedToDatePicker;

    String dateFormat;

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

        dateFormat = "%s %d, %d";

        setupToolbar();
        setupDatePickers();
        setupClickListeners();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (releasedFromDatePicker == null)
            releasedFromDatePicker = (DatePickerDialog) getFragmentManager().findFragmentByTag("fromDatePicker");
        if (releasedToDatePicker == null)
            releasedToDatePicker = (DatePickerDialog) getFragmentManager().findFragmentByTag("toDatePicker");

        setupDatePickersListeners();
    }

    private void setupToolbar() {
        toolbar.showExpandedPurpleToolbarSaveInput(
                getString(R.string.new_query),
                this,
                v -> presenter.onSaveClick());
    }

    private void setupDatePickers() {
        Calendar now = Calendar.getInstance();
        releasedFromDatePicker = DatePickerDialog.newInstance(
                (view, year, monthOfYear, dayOfMonth) -> presenter.onFromDatePicked(year, monthOfYear, dayOfMonth),
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        releasedToDatePicker = DatePickerDialog.newInstance(
                (view, year, monthOfYear, dayOfMonth) -> presenter.onToDatePicked(year, monthOfYear, dayOfMonth),
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
    }

    private void setupDatePickersListeners() {
        if (releasedFromDatePicker != null)
            releasedFromDatePicker.setOnDateSetListener(
                    (view, year, monthOfYear, dayOfMonth) -> presenter.onFromDatePicked(year, monthOfYear, dayOfMonth)
            );
        if (releasedToDatePicker != null)
            releasedToDatePicker.setOnDateSetListener(
                    (view, year, monthOfYear, dayOfMonth) -> presenter.onToDatePicked(year, monthOfYear, dayOfMonth)
            );
    }

    private void setupClickListeners() {
        releasedFrom.setOnClickListener(v -> releasedFromDatePicker.show(getFragmentManager(), "fromDatePicker"));
        releasedTo.setOnClickListener(v -> releasedToDatePicker.show(getFragmentManager(), "toDatePicker"));
    }


    String getNameInput() {
        return toolbar.getInputText();
    }

    void setNameInput(String input) {
        toolbar.setInputText(input);
    }

    void setReleasedFromText(Calendar calendar) {
        setReleasedFromText(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
    }

    void setReleasedFromText(int year, int monthOfYear, int dayOfMonth) {
        releasedFrom.setText(String.format(
                dateFormat,
                getMonthForInt(monthOfYear),
                dayOfMonth,
                year));
    }

    MonthAdapter.CalendarDay getReleasedFromDate() {
        return releasedFromDatePicker.getSelectedDay();
    }

    void setReleasedToText(Calendar calendar) {
        setReleasedToText(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
    }

    void setReleasedToText(int year, int monthOfYear, int dayOfMonth) {
        releasedTo.setText(String.format(
                dateFormat,
                getMonthForInt(monthOfYear),
                dayOfMonth,
                year));
    }

    MonthAdapter.CalendarDay getReleasedToDate() {
        return releasedToDatePicker.getSelectedDay();
    }

    private String getMonthForInt(int num) {
        String month = "wrong";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11) {
            month = months[num];
        }
        return month;
    }
}
