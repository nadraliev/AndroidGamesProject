package com.soutvoid.gamesproject.ui.common.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by andrew on 4/17/17.
 */

public abstract class BindableViewHolder<T> extends RecyclerView.ViewHolder {

    public BindableViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(T data);
}
