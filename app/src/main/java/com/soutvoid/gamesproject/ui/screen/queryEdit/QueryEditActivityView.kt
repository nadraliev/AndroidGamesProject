package com.soutvoid.gamesproject.ui.screen.queryEdit

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.Switch
import android.widget.TextView
import butterknife.BindView
import com.agna.ferro.mvp.component.ScreenComponent
import com.annimon.stream.Stream
import com.google.android.flexbox.FlexboxLayout
import com.soutvoid.gamesproject.domain.genre.Genre
import com.soutvoid.gamesproject.ui.base.activity.BaseActivityView
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter
import com.soutvoid.gamesproject.ui.base.widgets.IgdbToolbar
import com.soutvoid.gamesproject.ui.screen.queryEdit.data.QueryData
import com.soutvoid.gamesproject.ui.screen.queryEdit.widgets.choosableDate.ChoosableDateTextView
import com.soutvoid.gamesproject.ui.screen.queryEdit.widgets.genreToggleBtn.GenreToggleBtn
import com.wdullaer.materialdatetimepicker.date.MonthAdapter
import soutvoid.com.gamesproject.R
import java.util.*
import javax.inject.Inject

class QueryEditActivityView : BaseActivityView() {

    @BindView(R.id.toolbar)
    var toolbar: IgdbToolbar? = null
    @BindView(R.id.section_released_from_date)
    var releasedFromDate: ChoosableDateTextView? = null
    @BindView(R.id.section_released_to_date)
    var releasedToDate: ChoosableDateTextView? = null
    @BindView(R.id.section_released_include_to)
    var includeTo: Switch? = null

    @BindView(R.id.section_released_to)
    var releasedTo: TextView? = null

    @BindView(R.id.section_genres_flexbox)
    var genresFlexbox: FlexboxLayout? = null

    @Inject
    lateinit internal var presenter: QueryEditActivityPresenter

    override fun getPresenter(): BasePresenter<*> {
        return presenter
    }

    override fun getName(): String {
        return javaClass.simpleName
    }

    override fun getContentView(): Int {
        return R.layout.activity_query_edit
    }

    override fun createScreenComponent(): ScreenComponent<*> {
        return DaggerQueryEditActivityComponent.builder()
                .activityModule(activityModule)
                .appComponent(appComponent)
                .build()
    }

    override fun onCreate(savedInstanceState: Bundle?, viewRecreated: Boolean) {
        super.onCreate(savedInstanceState, viewRecreated)

        setupToolbar()
        setupDatePickers()
        setupViews()
    }

    private fun setupToolbar() {
        toolbar!!.showExpandedPurpleToolbarSaveInput(
                getString(R.string.new_query),
                this
        ) { v -> presenter!!.onSaveClick() }
    }

    private fun setupDatePickers() {
        releasedFromDate!!.setActivity(this)
        releasedToDate!!.setActivity(this)
    }

    private fun setupViews() {
        includeTo!!.setOnCheckedChangeListener { btn, isChecked -> presenter!!.onReleasedIncludeToClicked(btn, isChecked) }
    }


    internal var nameInput: String
        get() = toolbar!!.inputText
        set(input) {
            toolbar!!.inputText = input
        }

    internal fun getReleasedFromDate(): MonthAdapter.CalendarDay {
        return releasedFromDate!!.selectedDay
    }

    internal fun getReleasedToDate(): MonthAdapter.CalendarDay {
        return releasedToDate!!.selectedDay
    }

    internal fun setGenresList(genres: List<Genre>) {
        Stream.of(genres).forEach { genre ->
            val genreToggleBtn = GenreToggleBtn(this)
            genreToggleBtn.text = genre.name
            genresFlexbox!!.addView(genreToggleBtn)
        }
    }

    internal val data: QueryData
        get() = QueryData(
                nameInput,
                getReleasedFromDate(),
                getReleasedToDate(),
                selectedGenres
        )

    internal fun toggleReleasedToDatePicker(enabled: Boolean) {
        releasedToDate!!.isEnabled = enabled
        var textColorId = R.color.black_transparent_40
        if (enabled)
            textColorId = R.color.colorTextInverse
        releasedTo!!.setTextColor(ContextCompat.getColor(this, textColorId))
        releasedToDate!!.setTextColor(ContextCompat.getColor(this, textColorId))
    }

    internal val isReleasedToIncluded: Boolean
        get() = includeTo!!.isChecked

    internal val selectedGenres: List<Int>
        get() {
            val genres = ArrayList<Int>()
            for (i in 0..genresFlexbox!!.childCount - 1) {
                if ((genresFlexbox!!.getChildAt(i) as GenreToggleBtn).isChecked)
                    genres.add(i)
            }
            return genres
        }

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, QueryEditActivityView::class.java)
            context.startActivity(intent)
        }
    }
}
