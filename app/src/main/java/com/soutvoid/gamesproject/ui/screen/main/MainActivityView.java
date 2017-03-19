package com.soutvoid.gamesproject.ui.screen.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.widget.TextView;

import com.agna.ferro.mvp.component.ScreenComponent;
import com.soutvoid.gamesproject.ui.base.activity.BaseActivityView;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.screen.main.exploreset.widget.ExploreSetView;

import javax.inject.Inject;

import soutvoid.com.gamesproject.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivityView extends BaseActivityView {

    @Inject
    MainActivityPresenter presenter;

    TextView testText;
    FloatingActionButton floatingActionButton;
    ExploreSetView exploreSetViewPopular;

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivityView.class);
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
        return R.layout.activity_main;
    }

    @Override
    protected ScreenComponent createScreenComponent() {
        return DaggerMainActivityComponent.builder()
                .activityModule(getActivityModule())
                .appComponent(getAppComponent())
                .build();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState, boolean viewRecreated) {
        findViews();
    }

    private void findViews() {
        testText = (TextView) findViewById(R.id.testText);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        exploreSetViewPopular = (ExploreSetView) findViewById(R.id.main_explore_set_popular);
    }
}
