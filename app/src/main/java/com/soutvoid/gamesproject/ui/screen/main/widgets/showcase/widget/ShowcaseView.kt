package com.soutvoid.gamesproject.ui.screen.main.widgets.showcase.widget

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSnapHelper
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import butterknife.BindView
import butterknife.ButterKnife
import com.soutvoid.gamesproject.domain.game.Game
import com.soutvoid.gamesproject.ui.base.widgets.AutoScrollingRecyclerView
import com.soutvoid.gamesproject.ui.screen.main.widgets.showcase.list.ShowcaseRecyclerAdapter
import com.soutvoid.gamesproject.ui.util.OnGameClickListener
import soutvoid.com.gamesproject.R
import java.util.*

class ShowcaseView : FrameLayout {

    private var viewContext: Context? = null

    @BindView(R.id.main_showcase_view_list)
    internal var list: AutoScrollingRecyclerView? = null
    @BindView(R.id.main_showcase_view_left_arrow)
    internal var leftArrow: View? = null
    @BindView(R.id.main_showcase_view_right_arrow)
    internal var rightArrow: View? = null

    private var currentPosition = 0

    private var showcaseRecyclerAdapter: ShowcaseRecyclerAdapter? = null
    private var onGameClickListener: OnGameClickListener? = null
    private var layoutManager: LinearLayoutManager? = null

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    private fun init(context: Context, attributeSet: AttributeSet?) {
        this.viewContext = context
        View.inflate(context, R.layout.showcase_view, this)
        ButterKnife.bind(this)
    }

    private fun initNavigationButtons() {
        leftArrow!!.setOnClickListener { v ->
            if (currentPosition - 1 >= 0)
                list!!.smoothScrollToPosition(--currentPosition)
        }

        rightArrow!!.setOnClickListener { v ->
            if (currentPosition + 1 < showcaseRecyclerAdapter!!.itemCount)
                list!!.smoothScrollToPosition(++currentPosition)
        }
    }

    private fun initList(games: ArrayList<Game>) {
        showcaseRecyclerAdapter = ShowcaseRecyclerAdapter(viewContext, games)
        showcaseRecyclerAdapter!!.setListener { pos, v ->
            if (onGameClickListener != null)
                onGameClickListener!!.onClick(showcaseRecyclerAdapter!!.games[pos], v)
        }
        layoutManager = LinearLayoutManager(viewContext, LinearLayoutManager.HORIZONTAL, false)
        list!!.layoutManager = layoutManager
        list!!.adapter = showcaseRecyclerAdapter
        LinearSnapHelper().attachToRecyclerView(list)

        list!!.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                currentPosition = layoutManager!!.findFirstVisibleItemPosition()

                if (layoutManager!!.findFirstCompletelyVisibleItemPosition() == 0)
                    leftArrow!!.visibility = View.GONE
                else if (layoutManager!!.findLastCompletelyVisibleItemPosition() == showcaseRecyclerAdapter!!.itemCount - 1)
                    rightArrow!!.visibility = View.GONE
                else {
                    leftArrow!!.visibility = View.VISIBLE
                    rightArrow!!.visibility = View.VISIBLE
                }
            }
        })

        initNavigationButtons()
    }

    fun setGamesListContent(games: ArrayList<Game>) {
        if (showcaseRecyclerAdapter == null)
            initList(games)
        else {
            showcaseRecyclerAdapter!!.games = games
            showcaseRecyclerAdapter!!.notifyDataSetChanged()
        }
    }

    fun addGamesListContent(games: ArrayList<Game>) {
        if (showcaseRecyclerAdapter == null) {
            initList(games)
        } else {
            val previousSize = showcaseRecyclerAdapter!!.games.size
            showcaseRecyclerAdapter!!.games.addAll(games)
            showcaseRecyclerAdapter!!.notifyItemRangeInserted(previousSize - 1, games.size)
        }
    }

    fun setOnGameClickListener(onGameClickListener: OnGameClickListener) {
        this.onGameClickListener = onGameClickListener
    }
}
