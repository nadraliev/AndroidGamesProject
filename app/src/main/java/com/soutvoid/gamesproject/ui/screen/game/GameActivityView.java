package com.soutvoid.gamesproject.ui.screen.game;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.agna.ferro.mvp.component.ScreenComponent;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.soutvoid.gamesproject.domain.game.Game;
import com.soutvoid.gamesproject.interactor.util.ImageUrlBuilder;
import com.soutvoid.gamesproject.ui.base.activity.BaseActivityView;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;

import java.io.File;

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
    @BindView(R.id.game_title)
    TextView title;
    @BindView(R.id.game_year)
    TextView year;
    @BindView(R.id.game_status)
    TextView status;
    @BindView(R.id.game_app_bar_title_placeholder)
    View appBarTitlePlaceholder;
    @BindView(R.id.game_year_status_separator)
    View yearStatusSeparator;

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
                .downloadOnly(new SimpleTarget<File>() {
                    @Override
                    public void onResourceReady(File resource, GlideAnimation<? super File> glideAnimation) {
                        if (resource != null)
                            presenter.mainImageDownloaded(resource);
                    }
                });
    }

    void showTopImage(Bitmap bitmap) {
        imageTop.setImageBitmap(bitmap);
    }

    void showTopImage(File file) {
        showTopImage(BitmapFactory.decodeFile(file.getPath()));
    }

    void downloadCover(String url) {
        Glide.with(this)
                .load(new ImageUrlBuilder().parse(url).setSize(ImageUrlBuilder.ImageSize.cover_big).build())
                .into(cover);
    }

    void showTitle(String str) {
        title.setText(str);
    }

    void showYear(String str) {
        year.setText(str);
    }

    void showStatus(String str) {
        status.setText(str);
    }

    void setAppBarColor(int color) {
        appBarTitlePlaceholder.setBackgroundColor(color);
    }

    void setTitleTextColor(int color) {
        title.setTextColor(color);
    }

    void setYearTextColor(int color) {
        year.setTextColor(color);
    }

    void setStatusTextColor(int color) {
        status.setTextColor(color);
    }

    void setYearStatusSeparatorColor(int color) {
        yearStatusSeparator.getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
    }

    void setSubtitleColor(int color) {
        setYearTextColor(color);
        setStatusTextColor(color);
        setYearStatusSeparatorColor(color);
    }

    void colorAsMainImage(File file) {
        Palette.from(BitmapFactory.decodeFile(file.getPath())).generate(p -> {
            int appBarColor = -1;
            int titleColor = -1;
            int subtitleColor = -1;
            if (p.getVibrantSwatch() != null) {
                appBarColor = p.getVibrantSwatch().getRgb();
                subtitleColor = p.getVibrantSwatch().getTitleTextColor();
                titleColor = p.getVibrantSwatch().getBodyTextColor();
            } else if (p.getDominantSwatch() != null) {
                appBarColor = p.getDominantSwatch().getRgb();
                subtitleColor = p.getDominantSwatch().getTitleTextColor();
                titleColor = p.getDominantSwatch().getBodyTextColor();
            }


            if (appBarColor != -1) setAppBarColor(appBarColor);
            if (titleColor != -1) setTitleTextColor(titleColor);
            if (subtitleColor != -1) setSubtitleColor(subtitleColor);
        });
    }

}
