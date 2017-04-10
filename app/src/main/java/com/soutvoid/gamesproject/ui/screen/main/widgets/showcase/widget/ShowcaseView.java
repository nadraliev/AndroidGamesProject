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
    private View leftArrow;
    private View rightArrow;
    private int currentPosition = 0;

    private ShowcaseRecyclerAdapter showcaseRecyclerAdapter;
    private LinearLayoutManager layoutManager;

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
        findViews();
    }

    private void findViews() {
        list = (RecyclerView) findViewById(R.id.main_showcase_view_list);
        leftArrow = findViewById(R.id.main_showcase_view_left_arrow);
        rightArrow = findViewById(R.id.main_showcase_view_right_arrow);
    }

    private void initNavigationButtons() {
        leftArrow.setOnClickListener(v -> {
                    if (currentPosition - 1 >= 0)
                        list.smoothScrollToPosition(--currentPosition);
                }
        );

        rightArrow.setOnClickListener(v -> {
                    if (currentPosition + 1 < showcaseRecyclerAdapter.getItemCount())
                        list.smoothScrollToPosition(++currentPosition);
                }
        );
    }

    private void initList(ArrayList<Game> games) {
        showcaseRecyclerAdapter = new ShowcaseRecyclerAdapter(context, games);
        layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        list.setLayoutManager(layoutManager);
        list.setAdapter(showcaseRecyclerAdapter);
        new LinearSnapHelper().attachToRecyclerView(list);

        list.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                currentPosition = layoutManager.findFirstVisibleItemPosition();

                if (layoutManager.findFirstCompletelyVisibleItemPosition() == 0)
                    leftArrow.setVisibility(GONE);
                else if (layoutManager.findLastCompletelyVisibleItemPosition() == showcaseRecyclerAdapter.getItemCount() - 1)
                    rightArrow.setVisibility(GONE);
                else {
                    leftArrow.setVisibility(VISIBLE);
                    rightArrow.setVisibility(VISIBLE);
                }
            }
        });

        initNavigationButtons();
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