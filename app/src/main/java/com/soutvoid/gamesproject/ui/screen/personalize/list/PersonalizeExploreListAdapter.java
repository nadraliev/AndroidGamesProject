package com.soutvoid.gamesproject.ui.screen.personalize.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.annimon.stream.Stream;
import com.google.android.flexbox.FlexboxLayout;
import com.soutvoid.gamesproject.interactor.util.ExploreQuery;
import com.soutvoid.gamesproject.ui.common.recycler.BindableViewHolder;

import java.util.List;

import butterknife.BindView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import soutvoid.com.gamesproject.R;

@AllArgsConstructor
public class PersonalizeExploreListAdapter extends RecyclerView.Adapter<PersonalizeExploreListAdapter.PersonalizeExploreListViewHolder> {

    private Context context;
    @Setter
    @Getter
    private List<ExploreQuery> queries;

    public PersonalizeExploreListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public PersonalizeExploreListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.personalize_explore_list_item, parent, false);
        return new PersonalizeExploreListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonalizeExploreListViewHolder holder, int position) {
        holder.bind(Stream.of(queries).filter(
                query -> query.getPosition() == position
        ).findFirst().get());
    }

    @Override
    public int getItemCount() {
        return queries.size();
    }

    public static class PersonalizeExploreListViewHolder extends BindableViewHolder<ExploreQuery> {

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
        public void bind(ExploreQuery data) {
            name.setText(data.getName());
            //TODO bind tags from query
        }
    }

}
