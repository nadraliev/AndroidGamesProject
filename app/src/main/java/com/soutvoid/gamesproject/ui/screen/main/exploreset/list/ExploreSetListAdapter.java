package com.soutvoid.gamesproject.ui.screen.main.exploreset.list;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.soutvoid.gamesproject.domain.game.Game;

import java.util.ArrayList;

import soutvoid.com.gamesproject.R;


public class ExploreSetListAdapter extends RecyclerView.Adapter<ExploreSetListAdapter.ExploreSetListViewHolder> {

    private Context context;
    private ArrayList<Game> games;

    public ExploreSetListAdapter(Context context, ArrayList<Game> games) {
        this.context = context;
        this.games = games;
    }

    @Override
    public ExploreSetListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.explore_set_view_list_item, parent, false);
        return new ExploreSetListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExploreSetListViewHolder holder, int position) {
        String url = "https:" + games.get(position).getCover().url;
        Glide.with(context)
                .load(url)
                .dontAnimate()
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    public static class ExploreSetListViewHolder extends RecyclerView.ViewHolder {

        public CardView container;
        public ImageView image;

        public ExploreSetListViewHolder(View itemView) {
            super(itemView);
            container = (CardView) itemView.findViewById(R.id.main_explore_set_list_item_container);
            image = (ImageView) itemView.findViewById(R.id.main_explore_set_list_item_image);
        }
    }

}
