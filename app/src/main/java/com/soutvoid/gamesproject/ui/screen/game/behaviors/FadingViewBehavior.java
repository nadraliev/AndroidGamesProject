package com.soutvoid.gamesproject.ui.screen.game.behaviors;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

import soutvoid.com.gamesproject.R;

public class FadingViewBehavior extends CoordinatorLayout.Behavior<View> {

    private float customStartY;
    private float customEndY;

    private float startFadingPoint;
    private float endFadingPoint;

    private float startPosition;

    public FadingViewBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attributeSet) {
        bindAttrs(context, attributeSet);
    }

    private void bindAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray a = context.obtainStyledAttributes(attributeSet, R.styleable.FadingViewBehavior);
            customStartY = a.getDimension(R.styleable.FadingViewBehavior_startY, 0);
            customEndY = a.getDimension(R.styleable.FadingViewBehavior_endY, 0);

            a.recycle();
        }
    }

    private void maybeInitProperties(View child, View dependency) {
        if (startPosition == 0)
            startPosition = child.getY();
        if (startFadingPoint == 0 && startPosition != 0)
            startFadingPoint = startPosition - customStartY;
        if (endFadingPoint == 0 && startPosition != 0)
            endFadingPoint = customEndY;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof Toolbar;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        maybeInitProperties(child, dependency);

        final float maxScrollDistance = startFadingPoint - endFadingPoint - child.getMeasuredHeight() / 2;
        float currentY = child.getY() + child.getMeasuredHeight() / 2;

        if (currentY <= startFadingPoint) {
            float alpha = (currentY - customEndY - child.getMeasuredHeight() / 2) / maxScrollDistance;
            child.setAlpha(alpha);
        } else {
            child.setAlpha(1);
        }

        return true;
    }
}
