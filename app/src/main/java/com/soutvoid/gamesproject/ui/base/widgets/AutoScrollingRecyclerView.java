package com.soutvoid.gamesproject.ui.base.widgets;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * recycler, автоматически скроллящийся при отсутсвиии активности
 */
public class AutoScrollingRecyclerView extends RecyclerView {

    /**
     * интервал между скроллингом в миллисекундах
     */
    private int interval = 5000;
    private Handler handler;
    private Runnable runnable;

    public AutoScrollingRecyclerView(Context context) {
        super(context);
        initRunnable();
    }

    public AutoScrollingRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initRunnable();
    }

    private void initRunnable() {
        runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    smoothScrollToPosition(((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition() + 1);
                } catch (Exception e) {
                    //ignored
                }

                handler.postDelayed(this, interval);
            }
        };
    }

    @Override
    public void onScrolled(int dx, int dy) {
        super.onScrolled(dx, dy);
        startTimer();
    }

    /**
     * метод для запуска таймера
     */
    public void startTimer() {
        if (handler == null)
            handler = new Handler();
        handler.removeCallbacks(runnable);  //запуск таймера заново
        handler.postDelayed(runnable, interval);
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }
}
