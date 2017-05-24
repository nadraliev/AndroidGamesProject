package com.soutvoid.gamesproject.ui.screen.main.widgets.exploreset.widget

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.soutvoid.gamesproject.domain.game.Game
import com.soutvoid.gamesproject.interactor.util.ImageUrlBuilder
import com.soutvoid.gamesproject.ui.screen.main.widgets.exploreset.list.ExploreSetListAdapter
import com.soutvoid.gamesproject.ui.util.OnGameClickListener
import soutvoid.com.gamesproject.R
import java.util.*

class ExploreSetView : FrameLayout {

    private var viewContext: Context? = null

    @BindView(R.id.main_explore_set_container)
    internal var container: ViewGroup? = null
    @BindView(R.id.main_explore_set_background)
    internal var background: ImageView? = null
    @BindView(R.id.main_explore_set_background_tint)
    internal var backgroundTint: View? = null
    @BindView(R.id.main_explore_set_header)
    var header: TextView? = null
        internal set
    @BindView(R.id.main_explore_set_list)
    internal var list: RecyclerView? = null

    private var exploreSetListAdapter: ExploreSetListAdapter? = null

    private var onGameClickListener: OnGameClickListener? = null

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        this.viewContext = context
        View.inflate(context, R.layout.explore_set_view, this)
        ButterKnife.bind(this)
        fillFromAttrs(context, attrs)
    }

    private fun fillFromAttrs(context: Context, attrs: AttributeSet?) {
        if (attrs != null) {
            val typedArray = context.theme.obtainStyledAttributes(
                    attrs,
                    R.styleable.ExploreSetView, 0, 0)
            val textResourceId = typedArray.getResourceId(R.styleable.ExploreSetView_header, 0)
            val backgroundResourceId = typedArray.getResourceId(R.styleable.ExploreSetView_background, 0)
            val headerColorId = typedArray.getResourceId(R.styleable.ExploreSetView_headerColor, 0)
            background!!.setImageResource(backgroundResourceId)
            header!!.setText(textResourceId)
            setHeaderColor(headerColorId)
            typedArray.recycle()
        }
    }

    private fun initList(games: ArrayList<Game>) {
        exploreSetListAdapter = ExploreSetListAdapter(viewContext, games)
        exploreSetListAdapter!!.setOnListItemClickListener { pos, v ->
            if (onGameClickListener != null)
                onGameClickListener!!.onClick(exploreSetListAdapter!!.games[pos], v)
        }
        list!!.layoutManager = LinearLayoutManager(viewContext, LinearLayoutManager.HORIZONTAL, false)
        list!!.adapter = exploreSetListAdapter
    }

    fun setHeader(header: String) {
        this.header!!.text = header
    }

    fun setHeaderColor(colorId: Int) {
        header!!.setTextColor(colorId)
    }

    fun setGamesListContent(games: ArrayList<Game>) {
        if (exploreSetListAdapter == null)
            initList(games)
        else {
            exploreSetListAdapter!!.games = games
            exploreSetListAdapter!!.notifyDataSetChanged()
        }
    }

    fun addGamesListContent(games: ArrayList<Game>) {
        if (exploreSetListAdapter == null) {
            initList(games)
        } else {
            val previousSize = exploreSetListAdapter!!.games.size
            exploreSetListAdapter!!.games.addAll(games)
            exploreSetListAdapter!!.notifyItemRangeInserted(previousSize - 1, games.size)
        }
    }

    fun setBackgroundSource(drawable: Drawable) {
        background!!.setImageDrawable(drawable)
    }

    fun setBackgroundSource(bitmap: Bitmap) {
        background!!.setImageBitmap(bitmap)
    }

    override fun setBackgroundColor(color: Int) {
        background!!.setBackgroundColor(color)
    }

    fun chooseBackgroundFromGamesList() {
        var chosenUrl: String? = null
        for ((_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, screenshots) in exploreSetListAdapter!!.games) {
            if (screenshots != null && screenshots.size > 1) {
                chosenUrl = screenshots[1].getUrl()
                break
            }
        }
        if (chosenUrl != null) {
            val imageUrlBuilder = ImageUrlBuilder(chosenUrl)
            Glide.with(viewContext)
                    .load(imageUrlBuilder.setSize(ImageUrlBuilder.ImageSize.screenshot_big).build())
                    .into(background!!)
        }
    }

    fun setBackgroundTintVisibility(visibility: Boolean) {
        if (visibility)
            backgroundTint!!.visibility = View.VISIBLE
        else {
            backgroundTint!!.visibility = View.INVISIBLE
        }
    }

    fun setBackgroundTintAlpha(alpha: Float) {
        backgroundTint!!.alpha = alpha
    }

    fun setBackgroundTintColor(color: Int) {
        backgroundTint!!.setBackgroundColor(color)
    }

    fun setOnGameClickListener(onGameClickListener: OnGameClickListener) {
        this.onGameClickListener = onGameClickListener
    }
}
