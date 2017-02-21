package com.soutvoid.gamesproject.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.agna.ferro.mvp.component.ScreenComponent;
import com.agna.ferro.mvp.presenter.MvpPresenter;
import com.agna.ferro.mvp.view.activity.MvpActivityView;
import com.soutvoid.gamesproject.interactor.game.GameRepository;

import javax.inject.Inject;

import soutvoid.com.gamesproject.R;


public class MainActivity extends MvpActivityView {

    @Inject
    GameRepository gameRepository;


    @Override
    public String getName() {
        return null;
    }

    @Override
    protected int getContentView() {
        return 0;
    }

    @Override
    protected ScreenComponent createScreenComponent() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState, boolean viewRecreated) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, String.valueOf(gameRepository == null), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }

    @Override
    public MvpPresenter getPresenter() {
        return null;
    }
}
