package com.soutvoid.gamesproject.ui.base.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import soutvoid.com.gamesproject.R;

/**
 * view для отображения placeholder (loading, empty, error)
 */
public class PlaceholderView extends FrameLayout {

    public enum State {
        LOADING(0),
        EMPTY(1),
        ERROR(2);
        int id;

        State(int id) {
            this.id = id;
        }

        static State fromId(int id) {
            for (State state : values())
                if (state.id == id) return state;
            return LOADING;
        }
    }

    private State state;
    private Context context;

    public PlaceholderView(@NonNull Context context, State state) {
        super(context);
        this.state = state;
        this.context = context;
        init(context, null);
    }

    public PlaceholderView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attributeSet) {
        inflate(context, R.layout.placeholder_view_loading, this);

        if (attributeSet != null)
            fillFromAttrs(context, attributeSet);
    }

    private void fillFromAttrs(Context context, AttributeSet attributeSet) {
        TypedArray array = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PlaceholderView, 0, 0);

        if (array.hasValue(R.styleable.PlaceholderView_state))
            setState(State.fromId(array.getInt(R.styleable.PlaceholderView_state, 0)));

        array.recycle();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        switch (state) {
            case LOADING:
                inflate(context, R.layout.placeholder_view_loading, this);
                break;
            case EMPTY:
                //TODO make empty placeholder
                break;
            case ERROR:
                inflate(context, R.layout.placeholder_view_error, this);
                break;
        }
    }
}
