package com.soutvoid.gamesproject.ui.screen.main.widgets.showcase.list;

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
import com.soutvoid.gamesproject.ui.common.recycler.BindableViewHolder;
import com.soutvoid.gamesproject.ui.util.OnListItemClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import soutvoid.com.gamesproject.R;


public class ShowcaseRecyclerAdapter extends RecyclerView.Adapter<ShowcaseRecyclerAdapter.ShowcaseRecyclerViewHolder> {

    private Context context;
    private ArrayList<Game> games;
    private OnListItemClickListener listener;

    public ShowcaseRecyclerAdapter(Context context, ArrayList<Game> games) {
        this.context = context;
        this.games = games;
    }

    @Override
    public ShowcaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.showcase_list_item, parent, false);
        return new ShowcaseRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShowcaseRecyclerViewHolder holder, final int position) {
        holder.bind(games.get(position));

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

    public static class ShowcaseRecyclerViewHolder extends BindableViewHolder<Game> {

        @BindView(R.id.main_showcase_list_item_container)
        ViewGroup container;
        @BindView(R.id.main_showcase_list_item_image)
        ImageView imageView;
        @BindView(R.id.main_showcase_list_item_text)
        TextView textView;

        private ImageUrlBuilder imageUrlBuilder;

        public ShowcaseRecyclerViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            imageUrlBuilder = new ImageUrlBuilder();
        }

        @Override
        public void bind(Game data) {
            textView.setText(data.getName());

            if (data.getScreenshots() != null && data.getScreenshots().size() > 0) {
                String originalUrl = data.getScreenshots().get(0).getUrl();
                Glide.with(itemView.getContext())
                        .load(imageUrlBuilder.clear().parse(originalUrl).setSize(ImageUrlBuilder.ImageSize.screenshot_big).build())
                        .into(imageView);
            } else {
                imageView.setImageResource(R.color.colorTransparent);
            }
        }
    }

}
