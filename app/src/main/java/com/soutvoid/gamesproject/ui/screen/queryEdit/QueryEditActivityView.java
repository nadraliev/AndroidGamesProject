package com.soutvoid.gamesproject.ui.screen.queryEdit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;

import com.agna.ferro.mvp.component.ScreenComponent;
import com.soutvoid.gamesproject.ui.base.activity.BaseActivityView;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.base.widgets.IgdbToolbar;

import javax.inject.Inject;

import butterknife.BindView;
import soutvoid.com.gamesproject.R;

public class QueryEditActivityView extends BaseActivityView {

    @BindView(R.id.query_edit_name_text_input)
    TextInputLayout name;
    @BindView(R.id.toolbar)
    IgdbToolbar toolbar;

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
    }

    private void setupToolbar() {
        toolbar.showPurpleToolbarSave(
                getString(R.string.new_query),
                this,
                v -> presenter.onSaveClick());
    }


    String getNameInput() {
        return name.getEditText().getText().toString();
    }

    void setNameInput(String input) {
        name.getEditText().setText(input);
    }
}
