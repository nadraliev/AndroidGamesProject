package com.soutvoid.gamesproject.ui.screen.editQuery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import com.agna.ferro.mvp.component.ScreenComponent;
import com.soutvoid.gamesproject.ui.base.activity.BaseActivityView;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;

import javax.inject.Inject;

import butterknife.BindView;
import soutvoid.com.gamesproject.R;

public class EditQueryActivityView extends BaseActivityView {

    @BindView(R.id.query_edit_name_text_input)
    TextInputLayout name;
    @BindView(R.id.query_edit_save)
    Button save;
    @BindView(R.id.query_edit_toolbar)
    Toolbar toolbar;

    @Inject
    EditQueryActivityPresenter presenter;

    public static void start(Context context) {
        Intent intent = new Intent(context, EditQueryActivityView.class);
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
        return DaggerEditQueryActivityComponent.builder()
                .activityModule(getActivityModule())
                .appComponent(getAppComponent())
                .build();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState, boolean viewRecreated) {
        super.onCreate(savedInstanceState, viewRecreated);

        setupViews();
    }

    private void setupViews() {
        save.setOnClickListener(v -> presenter.onSaveClick());
    }

    String getNameInput() {
        return name.getEditText().getText().toString();
    }

    void setNameInput(String input) {
        name.getEditText().setText(input);
    }
}
