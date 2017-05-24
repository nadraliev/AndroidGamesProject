package com.soutvoid.gamesproject.ui.common.message;


import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import com.agna.ferro.mvp.component.provider.ActivityProvider;
import com.agna.ferro.mvp.component.scope.PerScreen;
import com.soutvoid.gamesproject.interactor.util.TransformUtil;

import javax.inject.Inject;

import soutvoid.com.gamesproject.R;

@PerScreen
public class MessagePresenter {

    private final ActivityProvider activityProvider;

    @Inject
    public MessagePresenter(ActivityProvider activityProvider) {
        this.activityProvider = activityProvider;
    }

    public void show(@StringRes int stringId) {
        View v = getView();
        Snackbar snackbar = Snackbar.make(v, stringId, Snackbar.LENGTH_LONG);
        setMultilineSnackbar(snackbar);
        snackbar.show();
    }

    public void show(String message) {
        View v = getView();
        Snackbar snackbar = Snackbar.make(v, TransformUtil.INSTANCE.sanitizeHtmlString(message), Snackbar.LENGTH_LONG);
        setMultilineSnackbar(snackbar);
        snackbar.show();
    }

    public void show(@IdRes int parentViewId, @StringRes int stringId) {
        View v = activityProvider.get().findViewById(parentViewId);
        Snackbar snackbar = Snackbar.make(v, stringId, Snackbar.LENGTH_LONG);
        setMultilineSnackbar(snackbar);
        snackbar.show();
    }

    private void setMultilineSnackbar(Snackbar snackbar) {
        TextView textView = (TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
        textView.setMaxLines(4);
    }

    /**
     * Для того, чтобы срабатывал Behavior на появление Snackbar,
     * нужно чтобы корневым контейнером экрана был CoordinatorLayout
     * с id = "coordinator_content". Если такого контейнера нет -
     * привязываемся к корневому элементу активити
     */
    private View getView() {

        View v = activityProvider.get().findViewById(R.id.coordinator_content);
        if (v == null) {
            v = activityProvider.get().findViewById(android.R.id.content);
        }
        return v;
    }

}
