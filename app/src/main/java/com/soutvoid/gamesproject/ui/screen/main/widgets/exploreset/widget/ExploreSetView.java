package com.soutvoid.gamesproject.ui.screen.main.widgets.exploreset.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.soutvoid.gamesproject.domain.game.Game;
import com.soutvoid.gamesproject.interactor.util.ImageUrlBuilder;
import com.soutvoid.gamesproject.ui.screen.main.widgets.exploreset.list.ExploreSetListAdapter;

import java.util.ArrayList;

import soutvoid.com.gamesproject.R;

public class ExploreSetView extends FrameLayout {

    private Context context;
    private ViewGroup container;
    private ImageView background;
    private View backgroundTint;
    private TextView header;
    private RecyclerView list;
    private ExploreSetListAdapter exploreSetListAdapter;

    public ExploreSetView(Context context) {
        super(context);
        init(context, null);
    }

    public ExploreSetView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs) {
        this.context = context;
        inflate(context, R.layout.explore_set_view, this);
        findViews();
        fillFromAttrs(context, attrs);
    }

    private void findViews() {
        container = (ViewGroup) findViewById(R.id.main_explore_set_container);
        background = (ImageView) findViewById(R.id.main_explore_set_background);
        backgroundTint = findViewById(R.id.main_explore_set_background_tint);
        header = (TextView) findViewById(R.id.main_explore_set_header);
        list = (RecyclerView) findViewById(R.id.main_explore_set_list);
    }

    private void fillFromAttrs(Context context, @Nullable AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.ExploreSetView, 0, 0);
            int textResourceId = typedArray.getResourceId(R.styleable.ExploreSetView_header, 0);
            int backgroundResourceId = typedArray.getResourceId(R.styleable.ExploreSetView_background, 0);
            int headerColorId = typedArray.getResourceId(R.styleable.ExploreSetView_headerColor, 0);
            background.setImageResource(backgroundResourceId);
            header.setText(textResourceId);
            setHeaderColor(headerColorId);
            typedArray.recycle();
        }
    }

    private void initList(ArrayList<Game> games) {
        exploreSetListAdapter = new ExploreSetListAdapter(context, games);
        list.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        list.setAdapter(exploreSetListAdapter);
    }

    public TextView getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header.setText(header);
    }

    public void setHeaderColor(int colorId) {
        header.setTextColor(colorId);
    }

    public void setGamesListContent(ArrayList<Game> games) {
        if (exploreSetListAdapter == null)
            initList(games);
        else {
            exploreSetListAdapter.setGames(games);
            exploreSetListAdapter.notifyDataSetChanged();
        }
    }

    public void addGamesListContent(ArrayList<Game> games) {
        if (exploreSetListAdapter == null) {
            initList((games));
        } else {
            int previousSize = exploreSetListAdapter.getGames().size();
            exploreSetListAdapter.getGames().addAll(games);
            exploreSetListAdapter.notifyItemRangeInserted(previousSize - 1, games.size());
        }
    }

    public void setBackgroundSource(Drawable drawable) {
        background.setImageDrawable(drawable);
    }

    public void setBackgroundSource(Bitmap bitmap) {
        background.setImageBitmap(bitmap);
    }

    public void setBackgroundColor(int color) {
        background.setBackgroundColor(color);
    }

    public void chooseBackgroundFromGamesList() {
        String chosenUrl = null;
        for (Game game : exploreSetListAdapter.getGames()) {
            if (game.getScreenshots() != null && game.getScreenshots().size() > 1) {
                chosenUrl = game.getScreenshots().get(1).getUrl();
                break;
            }
        }
        if (chosenUrl != null) {
            ImageUrlBuilder imageUrlBuilder = new ImageUrlBuilder(chosenUrl);
            Glide.with(context)
                    .load(imageUrlBuilder.setSize(ImageUrlBuilder.ImageSize.screenshot_big).build())
                    .into(background);
        }
    }

    public void setBackgroundTintVisibility(boolean visibility) {
        if (visibility)
            backgroundTint.setVisibility(VISIBLE);
        else {
            backgroundTint.setVisibility(INVISIBLE);
        }
    }

    public void setBackgroundTintAlpha(float alpha) {
        backgroundTint.setAlpha(alpha);
    }

    public void setBackgroundTintColor(int color) {
        backgroundTint.setBackgroundColor(color);
    }
}