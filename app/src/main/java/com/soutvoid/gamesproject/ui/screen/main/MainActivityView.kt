package com.soutvoid.gamesproject.ui.screen.main

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import butterknife.BindView
import com.agna.ferro.mvp.component.ScreenComponent
import com.soutvoid.gamesproject.domain.game.Game
import com.soutvoid.gamesproject.ui.base.LoadableContent
import com.soutvoid.gamesproject.ui.base.activity.BaseActivityView
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter
import com.soutvoid.gamesproject.ui.base.widgets.IgdbToolbar
import com.soutvoid.gamesproject.ui.base.widgets.PlaceholderView
import com.soutvoid.gamesproject.ui.screen.game.GameActivityView
import com.soutvoid.gamesproject.ui.screen.main.data.ExploreSets
import com.soutvoid.gamesproject.ui.screen.main.widgets.exploreset.widget.ExploreSetView
import com.soutvoid.gamesproject.ui.screen.main.widgets.showcase.widget.ShowcaseView
import com.soutvoid.gamesproject.ui.screen.personalize.PersonalizeActivityView
import com.soutvoid.gamesproject.ui.util.OnGameClickListener
import soutvoid.com.gamesproject.R
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
import java.util.*
import javax.inject.Inject

class MainActivityView : BaseActivityView(), LoadableContent {

    @Inject
    lateinit internal var presenter: MainActivityPresenter

    @BindView(R.id.toolbar)
    internal var toolbar: IgdbToolbar? = null
    @BindView(R.id.main_explore_sets_container)
    internal var exploreSetsContainer: LinearLayout? = null
    @BindView(R.id.main_showcase_view)
    internal var showcaseView: ShowcaseView? = null
    @BindView(R.id.main_placeholder_view)
    internal var placeholderView: PlaceholderView? = null
    @BindView(R.id.main_personalize_btn)
    internal var personalizeBtn: Button? = null

    private var exploreSetViews: ArrayList<ExploreSetView>? = null

    override fun getPresenter(): BasePresenter<*> {
        return presenter
    }

    override fun getName(): String {
        return javaClass.simpleName
    }

    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun createScreenComponent(): ScreenComponent<*> {
        return DaggerMainActivityComponent.builder()
                .activityModule(activityModule)
                .appComponent(appComponent)
                .build()
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?, viewRecreated: Boolean) {
        super.onCreate(savedInstanceState, viewRecreated)

        setupToolbar()
        setupViews()
        init()
    }

    private fun init() {
        exploreSetViews = ArrayList<ExploreSetView>()
    }

    private fun setupToolbar() {
        toolbar!!.showSearchListsToolbarNoBack(this,
                { v -> presenter!!.onSearchClick() }
        ) { v -> presenter!!.onListsClick() }
    }

    private fun setupViews() {
        personalizeBtn!!.setOnClickListener { v -> PersonalizeActivityView.start(this) }
        showcaseView!!.setOnGameClickListener(OnGameClickListener { game, view -> this.onGameClick(game, view) })
    }

    private fun onApplyExploreSetViewDefaults(exploreSetView: ExploreSetView) {
        exploreSetView.setHeaderColor(ContextCompat.getColor(this, R.color.main_explore_set_header_color))
        exploreSetView.setOnGameClickListener(OnGameClickListener { game, view -> this.onGameClick(game, view) })
    }

    private fun onGameClick(game: Game, view: View) {
        startGameActivity(game)
    }

    override fun showTransparentPlaceholder() {
        placeholderView!!.setBackgroundResource(R.color.colorTransparent)
        placeholderView!!.visibility = View.VISIBLE
    }

    override fun showPlaceholderWithBackground() {
        placeholderView!!.setBackgroundResource(R.color.colorBackground)
        placeholderView!!.visibility = View.VISIBLE
    }

    override fun hidePlaceholder() {
        placeholderView!!.visibility = View.GONE
    }

    fun setPlaceholderState(state: PlaceholderView.State) {
        placeholderView!!.state = state
    }

    /**
     * добавляет пустой блок ExploreSetView и задает параметры по умолчанию

     * @return возвращает номер блока для последующей манипуляции
     */
    @JvmOverloads fun onAddExploreSetView(index: Int = exploreSetViews!!.size): Int {
        val exploreSetView = ExploreSetView(this)
        onApplyExploreSetViewDefaults(exploreSetView)
        exploreSetViews!!.add(exploreSetView)
        exploreSetsContainer!!.addView(exploreSetView, index)
        return exploreSetViews!!.size - 1
    }

    fun onAddExploreSetView(games: ArrayList<Game>): Int {
        val index = onAddExploreSetView()
        onSetExploreViewGames(index, games)
        return index
    }

    fun onAddExploreSetView(header: String, games: ArrayList<Game>): Int {
        val index = onAddExploreSetView(games)
        onSetExploreViewHeader(index, header)
        return index
    }

    fun onDeleteAllExploreSets() {
        if (exploreSetViews != null)
            exploreSetViews!!.clear()
        exploreSetsContainer!!.removeAllViews()
    }

    fun onSetExploreViewHeader(index: Int, header: String) {
        exploreSetViews!![index].setHeader(header)
    }

    fun onSetExploreViewGames(index: Int, games: ArrayList<Game>) {
        exploreSetViews!![index].setGamesListContent(games)
    }

    fun onSetExploreViewBackgroundBitmap(index: Int, bitmap: Bitmap) {
        exploreSetViews!![index].setBackgroundSource(bitmap)
    }

    fun onSetExploreSetViewBackgroundFromGames(index: Int) {
        exploreSetViews!![index].chooseBackgroundFromGamesList()
    }

    fun onAddGamesToExploreSetView(index: Int, games: ArrayList<Game>) {
        exploreSetViews!![index].addGamesListContent(games)
    }

    fun onShowExploreSetsData(exploreSets: ExploreSets) {
        exploreSets.data!!.sortedBy { it.position }
                .forEach { onAddExploreSetView(it.name, it.games) }
    }

    fun onSetShowcaseViewGames(games: ArrayList<Game>) {
        showcaseView!!.setGamesListContent(games)
    }

    fun startGameActivity(game: Game) {
        GameActivityView.start(this, game)
    }

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, MainActivityView::class.java)
            context.startActivity(intent)
        }
    }
}
