package com.soutvoid.gamesproject.ui.base.activity;

import android.content.Context;
import android.os.Bundle;

import com.agna.ferro.mvp.component.ScreenComponent;
import com.agna.ferro.mvp.view.activity.MvpActivityView;
import com.soutvoid.gamesproject.app.App;
import com.soutvoid.gamesproject.app.dagger.AppComponent;
import com.soutvoid.gamesproject.app.log.LogConstants;
import com.soutvoid.gamesproject.app.log.RemoteLogger;

import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public abstract class BaseActivityView extends MvpActivityView {


    public abstract BasePresenter getPresenter();

    public AppComponent getAppComponent() {
        return ((App) getApplication()).getAppComponent();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState, boolean viewRecreated) {
        super.onCreate(savedInstanceState, viewRecreated);

        ButterKnife.bind(this);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onResume() {
        super.onResume();
        RemoteLogger.logMessage(String.format(LogConstants.LOG_SCREEN_RESUME_FORMAT, getName()));
    }

    @Override
    protected void onPause() {
        super.onPause();
        RemoteLogger.logMessage(String.format(LogConstants.LOG_SCREEN_PAUSE_FORMAT, getName()));
    }

    public ActivityModule getActivityModule() {
        return new ActivityModule(getPersistentScreenScope());
    }

    public ScreenComponent getScreenComponent() {
        return getPersistentScreenScope().getObject(ScreenComponent.class);
    }


}
