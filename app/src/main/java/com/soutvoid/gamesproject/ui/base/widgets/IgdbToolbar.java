package com.soutvoid.gamesproject.ui.base.widgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import soutvoid.com.gamesproject.R;

public class IgdbToolbar extends Toolbar {

    @BindView(R.id.toolbar_search_edt)
    EditText searchEdt;
    @Nullable
    @BindView(R.id.toolbar_lists_btn)
    Button listsBtn;
    @Nullable
    @BindView(R.id.toolbar_save_btn)
    Button saveBtn;

    public IgdbToolbar(Context context) {
        super(context);
    }

    public IgdbToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        ButterKnife.bind(this);
    }

    public void showSearchListsToolbar(Activity activity,
                                       OnClickListener onSearchClickListener,
                                       OnClickListener onListsClickListener) {
        setupToolbar(null, activity, false, true, true, onSearchClickListener, onListsClickListener, null);
    }

    public void showSearchListsToolbarNoBack(Activity activity,
                                             OnClickListener onSearchClickListener,
                                             OnClickListener onListsClickListener) {
        setupToolbar(null, activity, false, true, false, onSearchClickListener, onListsClickListener, null);
    }

    public void showPurpleToolbar(String title,
                                  Activity activity) {
        setupToolbar(title, activity, true, false, true, null, null, null);
    }

    public void showPurpleToolbarSave(String title,
                                      Activity activity,
                                      OnClickListener onSaveClickListener) {
        setupToolbar(title, activity, true, false, true, null, null, onSaveClickListener);
    }

    private void setupToolbar(String title,
                              Activity activity,
                              boolean isPurple,
                              boolean withSearch,
                              boolean withBack,
                              OnClickListener onSearchClickListener,
                              OnClickListener onListsClickListener,
                              OnClickListener onSaveClickListener) {
        if (title != null)
            setTitle(title);
        setNavigationOnClickListener(v -> activity.finish());

        if (isPurple) {
            setBackgroundColor(ContextCompat.getColor(activity, R.color.colorPrimary));
            setTitleTextColor(Color.WHITE);
            if (withBack) {
                setNavigationIcon(R.drawable.ic_back_light);
            }
        } else {
            if (withBack) {
                setNavigationIcon(R.drawable.ic_back_dark);
            }
        }

        if (onSearchClickListener != null) {
            searchEdt.setVisibility(withSearch ? VISIBLE : GONE);
            searchEdt.setOnClickListener(onSearchClickListener);
        } else {
            searchEdt.setVisibility(GONE);
        }

        if (onListsClickListener != null) {
            listsBtn.setOnClickListener(onListsClickListener);
        }

        if (onSaveClickListener != null) {
            saveBtn.setOnClickListener(onSaveClickListener);
        }
    }

    public void setSearchEnabled(boolean enabled) {
        searchEdt.setFocusable(enabled);
        searchEdt.setFocusableInTouchMode(enabled);
        if (enabled) {
            searchEdt.requestFocus();
        }
    }
}
