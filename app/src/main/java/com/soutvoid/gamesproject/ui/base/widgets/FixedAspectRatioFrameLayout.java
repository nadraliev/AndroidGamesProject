package com.soutvoid.gamesproject.ui.base.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import soutvoid.com.gamesproject.R;

/**
 * позволяет создавать view с заданными пропорциями
 * пропорции задаются числом width/height
 * чтобы установить главное измерение, поставить значение другого 0dp
 */

public class FixedAspectRatioFrameLayout extends FrameLayout {

    private float ratio;

    public FixedAspectRatioFrameLayout(@NonNull Context context) {
        super(context);
    }

    public FixedAspectRatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attributeSet) {
        fillFromAttrs(context, attributeSet);
    }

    private void fillFromAttrs(Context context, AttributeSet attributeSet) {
        TypedArray array = context.obtainStyledAttributes(attributeSet, R.styleable.FixedAspectRatioFrameLayout);

        ratio = array.getFloat(R.styleable.FixedAspectRatioFrameLayout_ratio, 0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int originalWidth = MeasureSpec.getSize(widthMeasureSpec);
        int originalHeight = MeasureSpec.getSize(heightMeasureSpec);

        int finalWidth = originalWidth;
        int finalHeight = originalHeight;

        if (ratio != 0) {

            if (originalHeight == 0) {
                finalHeight = (int) (originalWidth / ratio);
            } else if (originalWidth == 0) {
                finalWidth = (int) (originalHeight * ratio);
            }

        }
        super.onMeasure(
                MeasureSpec.makeMeasureSpec(finalWidth, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(finalHeight, MeasureSpec.EXACTLY)
        );
    }
}
