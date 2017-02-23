package com.soutvoid.gamesproject.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.soutvoid.gamesproject.app.App;
import com.soutvoid.gamesproject.domain.game.Game;
import com.soutvoid.gamesproject.interactor.character.CharacterRepository;
import com.soutvoid.gamesproject.interactor.game.GameRepository;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Subscriber;
import soutvoid.com.gamesproject.R;


public class MainActivity extends AppCompatActivity {

    @Inject
    GameRepository gameRepository;

    @Inject
    CharacterRepository characterRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createComponent().inject(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                gameRepository.getGamesById(1025, "*")
                        .subscribe(new Subscriber<ArrayList<Game>>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(ArrayList<Game> games) {
                                Toast.makeText(MainActivity.this, games.get(0).getName(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    public MainActivityComponent createComponent() {
        return DaggerMainActivityComponent.builder()
                .appComponent(((App) getApplication()).getAppComponent())
                .build();
    }

}
