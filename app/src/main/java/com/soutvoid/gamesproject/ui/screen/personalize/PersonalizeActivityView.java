package com.soutvoid.gamesproject.ui.screen.personalize;


import android.content.Context;
import android.content.Intent;

import com.agna.ferro.mvp.component.ScreenComponent;
import com.soutvoid.gamesproject.ui.base.activity.BaseActivityView;
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;

import javax.inject.Inject;

import soutvoid.com.gamesproject.R;

public class PersonalizeActivityView extends BaseActivityView {

    @Inject
    PersonalizeActivityPresenter presenter;

    public static void start(Context context) {
        Intent intent = new Intent(context, PersonalizeActivityView.class);
        context.startActivity(intent);
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
        return R.layout.activity_personalize;
    }

    @Override
    protected ScreenComponent createScreenComponent() {
        return DaggerPersonalizeActivityComponent.builder()
                .activityModule(getActivityModule())
                .appComponent(getAppComponent())
                .build();
    }


}
