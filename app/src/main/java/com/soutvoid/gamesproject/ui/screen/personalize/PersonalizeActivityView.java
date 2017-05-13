package com.soutvoid.gamesproject.ui.screen.personalize;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.agna.ferro.mvp.component.ScreenComponent;
import com.soutvoid.gamesproject.interactor.util.ExploreQuery;
import com.soutvoid.gamesproject.ui.base.activity.BaseActivityView;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.base.widgets.IgdbToolbar;
import com.soutvoid.gamesproject.ui.screen.personalize.list.PersonalizeExploreListAdapter;
import com.soutvoid.gamesproject.ui.screen.queryEdit.QueryEditActivityView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import soutvoid.com.gamesproject.R;

public class PersonalizeActivityView extends BaseActivityView {

    @BindView(R.id.toolbar)
    IgdbToolbar toolbar;
    @BindView(R.id.personalize_explore_list)
    RecyclerView list;
    @BindView(R.id.personalize_fab)
    FloatingActionButton fab;

    @Inject
    PersonalizeActivityPresenter presenter;

    PersonalizeExploreListAdapter adapter;

    public static void start(Context context) {
        Intent intent = new Intent(context, PersonalizeActivityView.class);
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
        return R.layout.activity_personalize;
    }

    @Override
    protected ScreenComponent createScreenComponent() {
        return DaggerPersonalizeActivityComponent.builder()
                .activityModule(getActivityModule())
                .appComponent(getAppComponent())
                .build();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState, boolean viewRecreated) {
        super.onCreate(savedInstanceState, viewRecreated);

        initList();
        setupToolbar();
        setupFab();
    }

    private void initList() {
        list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new PersonalizeExploreListAdapter(this);
        list.setAdapter(adapter);
    }

    private void setupToolbar() {
        toolbar.showPurpleToolbar(
                getString(R.string.personalize),
                this);
    }

    private void setupFab() {
        fab.setOnClickListener(v -> QueryEditActivityView.start(this));
    }

    void setQueriesContent(List<ExploreQuery> queriesContent) {
        adapter.setQueries(queriesContent);
        adapter.notifyDataSetChanged();
    }


}
