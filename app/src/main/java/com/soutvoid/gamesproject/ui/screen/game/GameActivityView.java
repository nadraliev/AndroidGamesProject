package com.soutvoid.gamesproject.ui.screen.game;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.agna.ferro.mvp.component.ScreenComponent;
import com.soutvoid.gamesproject.domain.game.Game;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.base.activity.NoLimitsActivityView;

import javax.inject.Inject;

import soutvoid.com.gamesproject.R;

public class GameActivityView extends NoLimitsActivityView {

    @Inject
    GameActivityPresenter presenter;

    public static void start(Context context, Game game) {
        Intent intent = new Intent(context, GameActivityView.class);
        intent.putExtra("game", game);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState, boolean viewRecreated) {
        super.onCreate(savedInstanceState, viewRecreated);
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
        return R.layout.activity_game;
    }

    @Override
    protected ScreenComponent createScreenComponent() {
        return DaggerGameActivityComponent.builder()
                .activityModule(getActivityModule())
                .appComponent(getAppComponent())
                .build();
    }
}
