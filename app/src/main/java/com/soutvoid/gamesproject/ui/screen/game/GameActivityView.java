package com.soutvoid.gamesproject.ui.screen.game;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.agna.ferro.mvp.component.ScreenComponent;
import com.bumptech.glide.Glide;
import com.soutvoid.gamesproject.domain.game.Game;
import com.soutvoid.gamesproject.interactor.util.ImageUrlBuilder;
import com.soutvoid.gamesproject.ui.base.activity.BaseActivityView;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;

import javax.inject.Inject;

import butterknife.BindView;
import soutvoid.com.gamesproject.R;

public class GameActivityView extends BaseActivityView {

    @Inject
    GameActivityPresenter presenter;

    @BindView(R.id.game_image_top)
    ImageView imageTop;
    @BindView(R.id.game_cover)
    ImageView cover;

    public static void start(Context context, Game game) {
        Intent intent = new Intent(context, GameActivityView.class);
        intent.putExtra("game", game);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState, boolean viewRecreated) {
        super.onCreate(savedInstanceState, viewRecreated);

        //setupToolbar();
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

//    private void setupToolbar() {
//        if (Build.VERSION.SDK_INT >= 19) {
//            ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
//            layoutParams.height += getStatusBarHeight();
//        }
//
//    }

    private int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    void downloadTopImage(String url) {
        Glide.with(this)
                .load(new ImageUrlBuilder().parse(url).setSize(ImageUrlBuilder.ImageSize.screenshot_big).build())
                .into(imageTop);
    }

    void downloadCover(String url) {
        Glide.with(this)
                .load(new ImageUrlBuilder().parse(url).setSize(ImageUrlBuilder.ImageSize.cover_big).build())
                .into(cover);
    }
}
