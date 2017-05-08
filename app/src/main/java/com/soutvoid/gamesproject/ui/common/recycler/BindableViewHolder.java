package com.soutvoid.gamesproject.ui.common.recycler;

import android.view.View;


public abstract class BindableViewHolder<T> extends BaseViewHolder {

    public BindableViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(T data);
}
