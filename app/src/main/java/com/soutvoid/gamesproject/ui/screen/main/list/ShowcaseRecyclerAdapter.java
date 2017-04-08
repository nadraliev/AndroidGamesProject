package com.soutvoid.gamesproject.ui.screen.main.list;

import android.content.Context;
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


public class ShowcaseRecyclerAdapter extends RecyclerView.Adapter<ShowcaseRecyclerAdapter.ShowcaseRecyclerViewHolder> {

    private Context context;
    private ArrayList<Game> games;
    private OnListItemClickListener listener;
    private ImageUrlBuilder imageUrlBuilder;

    public ShowcaseRecyclerAdapter(Context context, ArrayList<Game> games) {
        this.context = context;
        this.games = games;
        imageUrlBuilder = new ImageUrlBuilder();
    }

    @Override
    public ShowcaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.showcase_list_item, parent, false);
        return new ShowcaseRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShowcaseRecyclerViewHolder holder, int position) {
        holder.textView.setText(games.get(position).getName());

        if (games.get(position).getScreenshots() != null && games.get(position).getScreenshots().size() > 0) {
            String originalUrl = games.get(position).getScreenshots().get(0).getUrl();
            Glide.with(context)
                    .load(imageUrlBuilder.clear().parse(originalUrl).setSize(ImageUrlBuilder.ImageSize.screenshot_big).build())
                    .dontAnimate()
                    .into(holder.imageView);
        } else {
            //TODO insert placeholder
        }

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.click(position, v);
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

    public void setListener(OnListItemClickListener listener) {
        this.listener = listener;
    }

    public static class ShowcaseRecyclerViewHolder extends RecyclerView.ViewHolder {

        public ViewGroup container;
        public ImageView imageView;
        public TextView textView;

        public ShowcaseRecyclerViewHolder(View itemView) {
            super(itemView);

            container = (ViewGroup) itemView.findViewById(R.id.main_showcase_list_item_container);
            imageView = (ImageView) itemView.findViewById(R.id.main_showcase_list_item_image);
            textView = (TextView) itemView.findViewById(R.id.main_showcase_list_item_text);
        }
    }

}
