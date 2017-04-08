package com.soutvoid.gamesproject.ui.screen.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.agna.ferro.mvp.component.ScreenComponent;
import com.soutvoid.gamesproject.domain.game.Game;
import com.soutvoid.gamesproject.ui.base.activity.BaseActivityView;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.screen.main.list.ShowcaseRecyclerAdapter;
import com.soutvoid.gamesproject.ui.screen.main.widgets.exploreset.widget.ExploreSetView;

import java.util.ArrayList;

import javax.inject.Inject;

import soutvoid.com.gamesproject.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivityView extends BaseActivityView {

    @Inject
    MainActivityPresenter presenter;

    private Toolbar toolbar;
    private LinearLayout exploreSetsContainer;
    private RecyclerView showCaseList;
    private ShowcaseRecyclerAdapter showcaseRecyclerAdapter;

    private ArrayList<ExploreSetView> exploreSetViews;

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
        setupToolbar();
    }

    private void findViews() {
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        exploreSetsContainer = (LinearLayout) findViewById(R.id.main_explore_sets_container);
        showCaseList = (RecyclerView) findViewById(R.id.main_showcase_list);
    }

    private void setupToolbar() {

    }

    /**
     * добавляет пустой блок ExploreSetView и задает параметры по умолчанию
     *
     * @return возвращает номер блока для последующей манипуляции
     */
    public int onAddExploreSetView() {
        if (exploreSetViews == null)
            exploreSetViews = new ArrayList<>();
        ExploreSetView exploreSetView = new ExploreSetView(this);
        onApplyExploreSetViewDefaults(exploreSetView);
        exploreSetViews.add(exploreSetView);
        exploreSetsContainer.addView(exploreSetView);
        return exploreSetViews.size() - 1;
    }

    private void onApplyExploreSetViewDefaults(ExploreSetView exploreSetView) {
        exploreSetView.setHeaderColor(ContextCompat.getColor(this, R.color.main_explore_set_header_color));
    }

    public int onAddExploreSetView(ArrayList<Game> games) {
        int index = onAddExploreSetView();
        onSetExploreViewGames(index, games);
        return index;
    }

    public int onAddExploreSetView(String header, ArrayList<Game> games) {
        int index = onAddExploreSetView(games);
        onSetExploreViewHeader(index, header);
        return index;
    }

    public void onSetExploreViewHeader(int index, String header) {
        exploreSetViews.get(index).setHeader(header);
    }

    public void onSetExploreViewGames(int index, ArrayList<Game> games) {
        exploreSetViews.get(index).setGamesListContent(games);
    }

    public void onSetExploreViewBackgroundBitmap(int index, Bitmap bitmap) {
        exploreSetViews.get(index).setBackgroundSource(bitmap);
    }

    public void onSetExploreSetViewBackgroundFromGames(int index) {
        exploreSetViews.get(index).chooseBackgroundFromGamesList();
    }

    public void onAddGamesToExploreSetView(int index, ArrayList<Game> games) {
        exploreSetViews.get(index).addGamesListContent(games);
    }

    private void setupShowcase(ArrayList<Game> games) {
        showcaseRecyclerAdapter = new ShowcaseRecyclerAdapter(this, games);
        showCaseList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        showCaseList.setAdapter(showcaseRecyclerAdapter);
        showCaseList.scrollToPosition(games.size() / 2);
    }

    public void onSetShowcaseGames(ArrayList<Game> games) {
        if (showcaseRecyclerAdapter == null)
            setupShowcase(games);
        else {
            showcaseRecyclerAdapter.setGames(games);
            showcaseRecyclerAdapter.notifyDataSetChanged();
            showCaseList.scrollToPosition(games.size() / 2);
        }
    }
}
