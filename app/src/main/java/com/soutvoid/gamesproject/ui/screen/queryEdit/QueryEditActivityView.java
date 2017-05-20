package com.soutvoid.gamesproject.ui.screen.queryEdit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Switch;
import android.widget.TextView;

import com.agna.ferro.mvp.component.ScreenComponent;
import com.annimon.stream.Stream;
import com.google.android.flexbox.FlexboxLayout;
import com.soutvoid.gamesproject.domain.genre.Genre;
import com.soutvoid.gamesproject.ui.base.activity.BaseActivityView;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.base.widgets.IgdbToolbar;
import com.soutvoid.gamesproject.ui.screen.queryEdit.data.QueryData;
import com.soutvoid.gamesproject.ui.screen.queryEdit.widgets.choosableDate.ChoosableDateTextView;
import com.soutvoid.gamesproject.ui.screen.queryEdit.widgets.genreToggleBtn.GenreToggleBtn;
import com.wdullaer.materialdatetimepicker.date.MonthAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import soutvoid.com.gamesproject.R;

public class QueryEditActivityView extends BaseActivityView {

    @BindView(R.id.toolbar)
    IgdbToolbar toolbar;
    @BindView(R.id.section_released_from_date)
    ChoosableDateTextView releasedFromDate;
    @BindView(R.id.section_released_to_date)
    ChoosableDateTextView releasedToDate;
    @BindView(R.id.section_released_include_to)
    Switch includeTo;

    @BindView(R.id.section_released_to)
    TextView releasedTo;

    @BindView(R.id.section_genres_flexbox)
    FlexboxLayout genresFlexbox;

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
        setupViews();
    }

    private void setupToolbar() {
        toolbar.showExpandedPurpleToolbarSaveInput(
                getString(R.string.new_query),
                this,
                v -> presenter.onSaveClick());
    }

    private void setupDatePickers() {
        releasedFromDate.setActivity(this);
        releasedToDate.setActivity(this);
    }

    private void setupViews() {
        includeTo.setOnCheckedChangeListener((btn, isChecked) ->
                presenter.onReleasedIncludeToClicked(btn, isChecked));
    }


    String getNameInput() {
        return toolbar.getInputText();
    }

    void setNameInput(String input) {
        toolbar.setInputText(input);
    }

    MonthAdapter.CalendarDay getReleasedFromDate() {
        return releasedFromDate.getSelectedDay();
    }

    MonthAdapter.CalendarDay getReleasedToDate() {
        return releasedToDate.getSelectedDay();
    }

    void setGenresList(List<Genre> genres) {
        Stream.of(genres).forEach(
                genre -> {
                    GenreToggleBtn genreToggleBtn = new GenreToggleBtn(this);
                    genreToggleBtn.setText(genre.getName());
                    genresFlexbox.addView(genreToggleBtn);
                }
        );
    }

    QueryData getData() {
        return new QueryData(
                getNameInput(),
                getReleasedFromDate(),
                getReleasedToDate()
        );
    }

    void toggleReleasedToDatePicker(boolean enabled) {
        releasedToDate.setEnabled(enabled);
        int textColorId = R.color.black_transparent_40;
        if (enabled)
            textColorId = R.color.colorTextInverse;
        releasedTo.setTextColor(ContextCompat.getColor(this, textColorId));
        releasedToDate.setTextColor(ContextCompat.getColor(this, textColorId));
    }

    boolean isReleasedToIncluded() {
        return includeTo.isChecked();
    }
}
