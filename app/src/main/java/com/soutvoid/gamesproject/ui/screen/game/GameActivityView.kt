package com.soutvoid.gamesproject.ui.screen.game

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v7.graphics.Palette
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import com.agna.ferro.mvp.component.ScreenComponent
import com.bumptech.glide.Glide
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import com.soutvoid.gamesproject.domain.game.Game
import com.soutvoid.gamesproject.interactor.util.ImageUrlBuilder
import com.soutvoid.gamesproject.ui.base.activity.BaseActivityView
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter
import io.codetail.animation.SupportAnimator
import soutvoid.com.gamesproject.R
import java.io.File
import javax.inject.Inject

class GameActivityView : BaseActivityView() {

    @Inject
    lateinit internal var presenter: GameActivityPresenter

    @BindView(R.id.game_image_top)
    internal var imageTop: ImageView? = null
    @BindView(R.id.game_cover)
    internal var cover: ImageView? = null
    @BindView(R.id.game_title)
    internal var title: TextView? = null
    @BindView(R.id.game_year)
    internal var year: TextView? = null
    @BindView(R.id.game_status)
    internal var status: TextView? = null
    @BindView(R.id.game_app_bar_title_placeholder)
    internal var appBarTitlePlaceholder: View? = null
    @BindView(R.id.game_reveal_background)
    internal var revealBackground: View? = null
    @BindView(R.id.game_reveal)
    internal var reveal: View? = null
    @BindView(R.id.game_year_status_separator)
    internal var yearStatusSeparator: View? = null

    override fun onCreate(savedInstanceState: Bundle?, viewRecreated: Boolean) {
        super.onCreate(savedInstanceState, viewRecreated)

        //setupToolbar();
    }

    override fun getPresenter(): BasePresenter<*> {
        return presenter
    }

    override fun getName(): String {
        return javaClass.simpleName
    }

    override fun getContentView(): Int {
        return R.layout.activity_game
    }

    override fun createScreenComponent(): ScreenComponent<*> {
        return DaggerGameActivityComponent.builder()
                .activityModule(activityModule)
                .appComponent(appComponent)
                .build()
    }

    //    private void setupToolbar() {
    //        if (Build.VERSION.SDK_INT >= 19) {
    //            ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
    //            layoutParams.height += getStatusBarHeight();
    //        }
    //
    //    }

    private val statusBarHeight: Int
        get() {
            var result = 0
            val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
            if (resourceId > 0) {
                result = resources.getDimensionPixelSize(resourceId)
            }
            return result
        }

    internal fun downloadTopImage(url: String) {
        Glide.with(this)
                .load(ImageUrlBuilder().parse(url).setSize(ImageUrlBuilder.ImageSize.screenshot_big).build())
                .downloadOnly(object : SimpleTarget<File>() {
                    override fun onResourceReady(resource: File?, glideAnimation: GlideAnimation<in File>) {
                        if (resource != null)
                            presenter!!.mainImageDownloaded(resource)
                    }
                })
    }

    internal fun showTopImage(bitmap: Bitmap) {
        imageTop!!.setImageBitmap(bitmap)
    }

    internal fun showTopImage(file: File) {
        showTopImage(BitmapFactory.decodeFile(file.path))
    }

    internal fun downloadCover(url: String) {
        Glide.with(this)
                .load(ImageUrlBuilder().parse(url).setSize(ImageUrlBuilder.ImageSize.cover_big).build())
                .into(cover!!)
    }

    internal fun showTitle(str: String) {
        title!!.text = str
    }

    internal fun showYear(str: String) {
        year!!.text = str
    }

    internal fun showStatus(str: String) {
        status!!.text = str
    }

    internal fun setAppBarColor(color: Int) {
        val fromColor = appBarTitlePlaceholder!!.solidColor

        val animator = io.codetail.animation.ViewAnimationUtils.createCircularReveal(
                reveal!!,
                appBarTitlePlaceholder!!.measuredWidth / 2,
                appBarTitlePlaceholder!!.measuredHeight / 2, 0f,
                (appBarTitlePlaceholder!!.measuredWidth / 2).toFloat()
        )

        animator.addListener(object : SupportAnimator.AnimatorListener {
            override fun onAnimationRepeat() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onAnimationEnd() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onAnimationCancel() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onAnimationStart() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

        revealBackground!!.setBackgroundColor(fromColor)
        animator.setDuration(200)
        animator.start()
        reveal!!.visibility = View.VISIBLE
    }

    internal fun setTitleTextColor(color: Int) {
        title!!.setTextColor(color)
    }

    internal fun setYearTextColor(color: Int) {
        year!!.setTextColor(color)
    }

    internal fun setStatusTextColor(color: Int) {
        status!!.setTextColor(color)
    }

    internal fun setYearStatusSeparatorColor(color: Int) {
        yearStatusSeparator!!.background.setColorFilter(color, PorterDuff.Mode.MULTIPLY)
    }

    internal fun setSubtitleColor(color: Int) {
        setYearTextColor(color)
        setStatusTextColor(color)
        setYearStatusSeparatorColor(color)
    }

    internal fun colorAsMainImage(file: File) {
        Palette.from(BitmapFactory.decodeFile(file.path)).generate { p ->
            var appBarColor = -1
            var titleColor = -1
            var subtitleColor = -1
            if (p.vibrantSwatch != null) {
                appBarColor = p.vibrantSwatch!!.rgb
                subtitleColor = p.vibrantSwatch!!.titleTextColor
                titleColor = p.vibrantSwatch!!.bodyTextColor
            } else if (p.dominantSwatch != null) {
                appBarColor = p.dominantSwatch!!.rgb
                subtitleColor = p.dominantSwatch!!.titleTextColor
                titleColor = p.dominantSwatch!!.bodyTextColor
            }


            if (appBarColor != -1) setAppBarColor(appBarColor)
            if (titleColor != -1) setTitleTextColor(titleColor)
            if (subtitleColor != -1) setSubtitleColor(subtitleColor)
        }
    }

    companion object {

        fun start(context: Context, game: Game) {
            val intent = Intent(context, GameActivityView::class.java)
            intent.putExtra("game", game)
            context.startActivity(intent)
        }
    }

}
