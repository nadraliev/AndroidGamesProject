package com.soutvoid.gamesproject.ui.screen.main.widgets.exploreset.list;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.soutvoid.gamesproject.domain.game.Game;
import com.soutvoid.gamesproject.interactor.util.ImageUrlBuilder;
import com.soutvoid.gamesproject.ui.util.OnListItemClickListener;

import java.util.ArrayList;

import soutvoid.com.gamesproject.R;


public class ExploreSetListAdapter extends RecyclerView.Adapter<ExploreSetListAdapter.ExploreSetListViewHolder> {

    private Context context;
    private ArrayList<Game> games;
    private ImageUrlBuilder imageUrlBuilder;
    private OnListItemClickListener listener;

    public ExploreSetListAdapter(Context context, ArrayList<Game> games) {
        this.context = context;
        this.games = games;
        imageUrlBuilder = new ImageUrlBuilder();
    }

    @Override
    public ExploreSetListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.explore_set_view_list_item, parent, false);
        return new ExploreSetListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExploreSetListViewHolder holder, int position) {
        holder.title.setText(games.get(position).getName());

        if (games.get(position).getScreenshots() != null && games.get(position).getScreenshots().size() > 0) {
            String originalUrl = games.get(position).getScreenshots().get(0).getUrl();
            Glide.with(context)
                    .load(imageUrlBuilder.clear().parse(originalUrl).setSize(ImageUrlBuilder.ImageSize.screenshot_big).build())
                    .dontAnimate()
                    .into(holder.image);
        } else {
            //TODO insert placeholder
        }

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invokeOnListItemClickEvent(position, holder.container);
            }
        });
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

    public void setOnListItemClickListener(OnListItemClickListener listener) {
        this.listener = listener;
    }

    private void invokeOnListItemClickEvent(int position, View view) {
        if (listener != null)
            listener.click(position, view);
    }

    public static class ExploreSetListViewHolder extends RecyclerView.ViewHolder {

        public CardView container;
        public ImageView image;
        public TextView title;

        public ExploreSetListViewHolder(View itemView) {
            super(itemView);
            container = (CardView) itemView.findViewById(R.id.main_explore_set_list_item_container);
            image = (ImageView) itemView.findViewById(R.id.main_explore_set_list_item_image);
            title = (TextView) itemView.findViewById(R.id.main_explore_set_list_item_title);
        }
    }

}
