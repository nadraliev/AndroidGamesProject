package com.soutvoid.gamesproject.ui.screen.main.widgets.showcase.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.soutvoid.gamesproject.domain.game.Game;
import com.soutvoid.gamesproject.ui.screen.main.widgets.showcase.list.ShowcaseRecyclerAdapter;

import java.util.ArrayList;

import soutvoid.com.gamesproject.R;

public class ShowcaseView extends FrameLayout {

    private Context context;

    private RecyclerView list;
    private View leftButton;
    private View rightButton;

    private ShowcaseRecyclerAdapter showcaseRecyclerAdapter;

    public ShowcaseView(Context context) {
        super(context);
        init(context, null);
    }

    public ShowcaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.context = context;
        inflate(context, R.layout.showcase_view, this);
        findViews(context);
    }

    private void findViews(Context context) {
        list = (RecyclerView) findViewById(R.id.main_showcase_view_list);
    }

    private void initList(ArrayList<Game> games) {
        showcaseRecyclerAdapter = new ShowcaseRecyclerAdapter(context, games);
        list.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        list.setAdapter(showcaseRecyclerAdapter);
        new LinearSnapHelper().attachToRecyclerView(list);
    }

    public void setGamesListContent(ArrayList<Game> games) {
        if (showcaseRecyclerAdapter == null)
            initList(games);
        else {
            showcaseRecyclerAdapter.setGames(games);
            showcaseRecyclerAdapter.notifyDataSetChanged();
        }
    }

    public void addGamesListContent(ArrayList<Game> games) {
        if (showcaseRecyclerAdapter == null) {
            initList((games));
        } else {
            int previousSize = showcaseRecyclerAdapter.getGames().size();
            showcaseRecyclerAdapter.getGames().addAll(games);
            showcaseRecyclerAdapter.notifyItemRangeInserted(previousSize - 1, games.size());
        }
    }
}
