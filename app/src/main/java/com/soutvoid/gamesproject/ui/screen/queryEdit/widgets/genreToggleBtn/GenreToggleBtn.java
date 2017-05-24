package com.soutvoid.gamesproject.ui.screen.queryEdit.widgets.genreToggleBtn;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import soutvoid.com.gamesproject.R;

public class GenreToggleBtn extends FrameLayout {

    @BindView(R.id.genre_toggle_btn_container)
    CardView container;

    @BindView(R.id.genre_toggle_btn_text)
    TextView textView;

    private boolean checked;

    private boolean touched;

    private int colorUnchecked;
    private int colorChecked;

    public GenreToggleBtn(Context context) {
        super(context);
        init(context);
    }

    public GenreToggleBtn(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.genre_toggle_btn, this);

        colorUnchecked = ContextCompat.getColor(context, R.color.colorGenreBtnUnchecked);
        colorChecked = ContextCompat.getColor(context, R.color.colorPrimary);

        ButterKnife.bind(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                touched = true;
                break;
            case MotionEvent.ACTION_MOVE:
                touched = true;
                break;
            case MotionEvent.ACTION_UP:
                if (touched)
                    onClick();
                touched = false;
                break;
            case MotionEvent.ACTION_CANCEL:
                touched = false;
                break;
            case MotionEvent.ACTION_OUTSIDE:
                touched = false;
                break;
            default:
        }
        return true;
    }

    private void onClick() {
        toggle();
    }

    public void toggle() {
        setChecked(!checked);
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
        if (checked)
            container.setCardBackgroundColor(colorChecked);
        else container.setCardBackgroundColor(colorUnchecked);
    }

    public void setText(String text) {
        textView.setText(text);
    }

    public String getText() {
        return textView.getText().toString();
    }

    public boolean isChecked() {
        return this.checked;
    }
}
