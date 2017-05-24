package com.soutvoid.gamesproject.ui.screen.personalize


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import com.agna.ferro.mvp.component.ScreenComponent
import com.soutvoid.gamesproject.interactor.util.ExploreQuery
import com.soutvoid.gamesproject.ui.base.activity.BaseActivityView
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter
import com.soutvoid.gamesproject.ui.base.widgets.IgdbToolbar
import com.soutvoid.gamesproject.ui.screen.personalize.list.PersonalizeExploreListAdapter
import com.soutvoid.gamesproject.ui.screen.queryEdit.QueryEditActivityView
import soutvoid.com.gamesproject.R
import javax.inject.Inject

class PersonalizeActivityView : BaseActivityView() {

    @BindView(R.id.toolbar)
    var toolbar: IgdbToolbar? = null
    @BindView(R.id.personalize_explore_list)
    var list: RecyclerView? = null
    @BindView(R.id.personalize_fab)
    var fab: FloatingActionButton? = null

    @Inject
    lateinit internal var presenter: PersonalizeActivityPresenter

    internal var adapter: PersonalizeExploreListAdapter? = null

    override fun getPresenter(): BasePresenter<*> {
        return presenter
    }

    override fun getName(): String {
        return javaClass.simpleName
    }

    override fun getContentView(): Int {
        return R.layout.activity_personalize
    }

    override fun createScreenComponent(): ScreenComponent<*> {
        return DaggerPersonalizeActivityComponent.builder()
                .activityModule(activityModule)
                .appComponent(appComponent)
                .build()
    }

    override fun onCreate(savedInstanceState: Bundle?, viewRecreated: Boolean) {
        super.onCreate(savedInstanceState, viewRecreated)

        initList()
        setupToolbar()
        setupFab()
    }

    private fun initList() {
        list!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter = PersonalizeExploreListAdapter(this)
        list!!.adapter = adapter
    }

    private fun setupToolbar() {
        toolbar!!.showPurpleToolbar(
                getString(R.string.personalize),
                this)
    }

    private fun setupFab() {
        fab!!.setOnClickListener { v -> QueryEditActivityView.start(this) }
    }

    internal fun setQueriesContent(queriesContent: List<ExploreQuery>) {
        adapter!!.queries = queriesContent
        adapter!!.notifyDataSetChanged()
    }

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, PersonalizeActivityView::class.java)
            context.startActivity(intent)
        }
    }


}
