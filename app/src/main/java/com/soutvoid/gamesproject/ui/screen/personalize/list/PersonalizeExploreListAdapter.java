package com.soutvoid.gamesproject.ui.screen.personalize.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;
import com.soutvoid.gamesproject.interactor.util.Query;
import com.soutvoid.gamesproject.ui.common.recycler.BindableViewHolder;

import java.util.List;

import butterknife.BindView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import soutvoid.com.gamesproject.R;

@AllArgsConstructor
@NoArgsConstructor
public class PersonalizeExploreListAdapter extends RecyclerView.Adapter<PersonalizeExploreListAdapter.PersonalizeExploreListViewHolder> {

    private Context context;
    @Setter
    @Getter
    private List<Query> queries;

    @Override
    public PersonalizeExploreListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.personalize_explore_list_item, parent, false);
        return new PersonalizeExploreListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonalizeExploreListViewHolder holder, int position) {
        holder.bind(queries.get(position));
    }

    @Override
    public int getItemCount() {
        return queries.size();
    }

    public static class PersonalizeExploreListViewHolder extends BindableViewHolder<Query> {

        @BindView(R.id.personalize_explore_list_container)
        ViewGroup container;
        @BindView(R.id.personalize_explore_list_name)
        TextView name;
        @BindView(R.id.personalize_explore_list_tags)
        FlexboxLayout tags;

        public PersonalizeExploreListViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bind(Query data) {
            name.setText(data.getName());
            //TODO bind tags from query
        }
    }

}
