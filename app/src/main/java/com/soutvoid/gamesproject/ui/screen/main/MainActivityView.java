package com.soutvoid.gamesproject.ui.screen.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.agna.ferro.mvp.component.ScreenComponent;
import com.annimon.stream.Stream;
import com.soutvoid.gamesproject.domain.game.Game;
import com.soutvoid.gamesproject.ui.base.LoadableContent;
import com.soutvoid.gamesproject.ui.base.activity.BaseActivityView;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.base.widgets.IgdbToolbar;
import com.soutvoid.gamesproject.ui.base.widgets.PlaceholderView;
import com.soutvoid.gamesproject.ui.screen.game.GameActivityView;
import com.soutvoid.gamesproject.ui.screen.main.data.ExploreSetData;
import com.soutvoid.gamesproject.ui.screen.main.data.ExploreSets;
import com.soutvoid.gamesproject.ui.screen.main.widgets.exploreset.widget.ExploreSetView;
import com.soutvoid.gamesproject.ui.screen.main.widgets.showcase.widget.ShowcaseView;
import com.soutvoid.gamesproject.ui.screen.personalize.PersonalizeActivityView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import soutvoid.com.gamesproject.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivityView extends BaseActivityView implements LoadableContent {

    @Inject
    MainActivityPresenter presenter;

    @BindView(R.id.toolbar)
    IgdbToolbar toolbar;
    @BindView(R.id.main_explore_sets_container)
    LinearLayout exploreSetsContainer;
    @BindView(R.id.main_showcase_view)
    ShowcaseView showcaseView;
    @BindView(R.id.main_placeholder_view)
    PlaceholderView placeholderView;
    @BindView(R.id.main_personalize_btn)
    Button personalizeBtn;

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

        setupToolbar();
        setupViews();
        init();
    }

    private void init() {
        exploreSetViews = new ArrayList<>();
    }

    private void setupToolbar() {
        toolbar.showSearchListsToolbarNoBack(this,
                v -> presenter.onSearchClick(),
                v -> presenter.onListsClick());
    }

    private void setupViews() {
        personalizeBtn.setOnClickListener(v -> PersonalizeActivityView.start(this));
        showcaseView.setOnGameClickListener(this::onGameClick);
    }

    private void onApplyExploreSetViewDefaults(ExploreSetView exploreSetView) {
        exploreSetView.setHeaderColor(ContextCompat.getColor(this, R.color.main_explore_set_header_color));
        exploreSetView.setOnGameClickListener(this::onGameClick);
    }

    private void onGameClick(Game game, View view) {
        startGameActivity(game);
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
    public int onAddExploreSetView(int index) {
        ExploreSetView exploreSetView = new ExploreSetView(this);
        onApplyExploreSetViewDefaults(exploreSetView);
        exploreSetViews.add(exploreSetView);
        exploreSetsContainer.addView(exploreSetView, index);
        return exploreSetViews.size() - 1;
    }

    public int onAddExploreSetView() {
        return onAddExploreSetView(exploreSetViews.size());
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

    public void onDeleteAllExploreSets() {
        if (exploreSetViews != null)
            exploreSetViews.clear();
        exploreSetsContainer.removeAllViews();
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

    public void onShowExploreSetsData(ExploreSets exploreSets) {
        Stream.of(exploreSets.getData()).
                sortBy(ExploreSetData::getPosition)
                .forEach(data -> onAddExploreSetView(data.getName(), data.getGames()));
    }

    public void onSetShowcaseViewGames(ArrayList<Game> games) {
        showcaseView.setGamesListContent(games);
    }

    public void startGameActivity(Game game) {
        GameActivityView.start(this, game);
    }
}
