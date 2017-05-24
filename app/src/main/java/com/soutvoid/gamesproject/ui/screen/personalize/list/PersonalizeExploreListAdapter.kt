package com.soutvoid.gamesproject.ui.screen.personalize.list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import com.annimon.stream.Stream
import com.google.android.flexbox.FlexboxLayout
import com.soutvoid.gamesproject.interactor.util.ExploreQuery
import com.soutvoid.gamesproject.ui.common.recycler.BindableViewHolder
import soutvoid.com.gamesproject.R

class PersonalizeExploreListAdapter : RecyclerView.Adapter<PersonalizeExploreListAdapter.PersonalizeExploreListViewHolder> {

    private var context: Context? = null
    var queries: List<ExploreQuery>? = null

    constructor(context: Context) {
        this.context = context
    }


    constructor(context: Context, queries: List<ExploreQuery>) {
        this.context = context
        this.queries = queries
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonalizeExploreListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.personalize_explore_list_item, parent, false)
        return PersonalizeExploreListViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonalizeExploreListViewHolder, position: Int) {
        holder.bind(Stream.of(queries).filter { query -> query.position == position }.findFirst().get())
    }

    override fun getItemCount(): Int {
        return queries!!.size
    }

    class PersonalizeExploreListViewHolder(itemView: View) : BindableViewHolder<ExploreQuery>(itemView) {

        @BindView(R.id.personalize_explore_list_container)
        internal var container: ViewGroup? = null
        @BindView(R.id.personalize_explore_list_name)
        internal var name: TextView? = null
        @BindView(R.id.personalize_explore_list_tags)
        internal var tags: FlexboxLayout? = null

        override fun bind(data: ExploreQuery) {
            name!!.text = data.name
            //TODO bind tags from query
        }
    }

}
