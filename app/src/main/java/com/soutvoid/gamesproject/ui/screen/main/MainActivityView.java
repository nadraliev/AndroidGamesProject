package com.soutvoid.gamesproject.ui.screen.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.agna.ferro.mvp.component.ScreenComponent;
import com.soutvoid.gamesproject.domain.game.Game;
import com.soutvoid.gamesproject.ui.base.LoadableContent;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.base.activity.TranslucentStatusActivityView;
import com.soutvoid.gamesproject.ui.base.widgets.PlaceholderView;
import com.soutvoid.gamesproject.ui.screen.main.widgets.exploreset.widget.ExploreSetView;
import com.soutvoid.gamesproject.ui.screen.main.widgets.showcase.widget.ShowcaseView;

import java.util.ArrayList;

import javax.inject.Inject;

import soutvoid.com.gamesproject.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivityView extends TranslucentStatusActivityView implements LoadableContent {

    @Inject
    MainActivityPresenter presenter;

    private Toolbar toolbar;
    private LinearLayout exploreSetsContainer;
    private ShowcaseView showcaseView;
    private PlaceholderView placeholderView;

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
        super.onCreate(savedInstanceState, viewRecreated);

        findViews();
        setupToolbar();
    }

    private void findViews() {
        exploreSetsContainer = (LinearLayout) findViewById(R.id.main_explore_sets_container);
        showcaseView = (ShowcaseView) findViewById(R.id.main_showcase_view);
        placeholderView = (PlaceholderView) findViewById(R.id.main_placeholder_view);
    }

    private void setupToolbar() {

    }

    @Override
    public void showTransparentPlaceholder() {
        placeholderView.setBackgroundResource(R.color.colorTransparent);
        placeholderView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showPlaceholderWithBackground() {
        placeholderView.setBackgroundResource(R.color.colorBackground);
        placeholderView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePlaceholder() {
        placeholderView.setVisibility(View.GONE);
    }

    public void setPlaceholderState(PlaceholderView.State state) {
        placeholderView.setState(state);
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

    public void onSetShowcaseViewGames(ArrayList<Game> games) {
        showcaseView.setGamesListContent(games);
    }
}
