package com.soutvoid.gamesproject.ui.screen.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.agna.ferro.mvp.component.ScreenComponent;
import com.soutvoid.gamesproject.domain.game.Game;
import com.soutvoid.gamesproject.ui.base.activity.BaseActivityView;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.screen.main.exploreset.widget.ExploreSetView;

import java.util.ArrayList;

import javax.inject.Inject;

import soutvoid.com.gamesproject.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivityView extends BaseActivityView {

    @Inject
    MainActivityPresenter presenter;

    private Toolbar toolbar;
    private LinearLayout exploreSetsContainer;

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
    }

    private void setupToolbar() {

    }

    /**
     * добавляет пустой блок ExploreSetView
     *
     * @return возвращает номер блока для последующей манипуляции
     */
    private int onAddExploreSetView() {
        if (exploreSetViews == null)
            exploreSetViews = new ArrayList<>();
        ExploreSetView exploreSetView = new ExploreSetView(this);
        exploreSetViews.add(exploreSetView);
        exploreSetsContainer.addView(exploreSetView);
        return exploreSetViews.size() - 1;
    }

    /**
     * добавляет новый блок ExploreSetView на экран под существующими
     *
     * @param header     заголовок блока
     * @param games      список игр для отображения
     * @param background фон блока
     * @return возвращает номер блока для последующей манипуляции
     */
    public int onAddExploreSetView(String header, ArrayList<Game> games, Drawable background) {
        int index = onAddExploreSetView();
        exploreSetViews.get(index).setHeader(header);
        exploreSetViews.get(index).setGamesListContent(games);
        exploreSetViews.get(index).setBackgroundSource(background);
        return index;
    }

    /**
     * то же, что и {@link #onAddExploreSetView(String, ArrayList, Drawable)}, но принимает Bitmap
     */
    public int onAddExploreSetView(String header, ArrayList<Game> games, Bitmap background) {
        int index = onAddExploreSetView();
        exploreSetViews.get(index).setHeader(header);
        exploreSetViews.get(index).setGamesListContent(games);
        exploreSetViews.get(index).setBackgroundSource(background);
        return index;
    }

    /**
     * то же, что и {@link #onAddExploreSetView(String, ArrayList, Drawable)}, но выбирает фон из скриншотов игр
     */
    public int onAddExploreSetView(String header, ArrayList<Game> games) {
        int index = onAddExploreSetView();
        exploreSetViews.get(index).setHeader(header);
        exploreSetViews.get(index).setGamesListContent(games);
        exploreSetViews.get(index).chooseBackgroundFromGamesList();
        return index;
    }

    /**
     * то же, что и {@link #onAddExploreSetView(String, ArrayList)}, но с дефолтным заголовком
     */
    public int onAddExploreSetView(ArrayList<Game> games) {
        int index = onAddExploreSetView();
        exploreSetViews.get(index).setGamesListContent(games);
        exploreSetViews.get(index).chooseBackgroundFromGamesList();
        return index;
    }

    public void onAddGamesToExploreSetView(int index, ArrayList<Game> games) {
        exploreSetViews.get(index).addGamesListContent(games);
    }
}
