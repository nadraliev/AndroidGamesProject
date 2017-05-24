package com.soutvoid.gamesproject.ui.base.widgets

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.v7.widget.Toolbar
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.EditText

import butterknife.BindView
import butterknife.ButterKnife
import soutvoid.com.gamesproject.R

class IgdbToolbar : Toolbar {

    @BindView(R.id.toolbar_search_edt)
    internal var searchEdt: EditText? = null
    @BindView(R.id.toolbar_input_edt)
    internal var inputEdt: EditText? = null
    @BindView(R.id.toolbar_lists_btn)
    internal var listsBtn: Button? = null
    @BindView(R.id.toolbar_save_btn)
    internal var saveBtn: Button? = null

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    override fun onFinishInflate() {
        super.onFinishInflate()

        ButterKnife.bind(this)
    }

    fun showSearchListsToolbar(activity: Activity,
                               onSearchClickListener: View.OnClickListener,
                               onListsClickListener: View.OnClickListener) {
        setupToolbar(null, activity, false, true, true, false, onSearchClickListener, onListsClickListener, null, null)
    }

    fun showSearchListsToolbarNoBack(activity: Activity,
                                     onSearchClickListener: View.OnClickListener,
                                     onListsClickListener: View.OnClickListener) {
        setupToolbar(null, activity, false, true, false, false, onSearchClickListener, onListsClickListener, null, null)
    }

    fun showPurpleToolbar(title: String,
                          activity: Activity) {
        setupToolbar(title, activity, true, false, true, false, null, null, null, null)
    }

    fun showPurpleToolbarSave(title: String,
                              activity: Activity,
                              onSaveClickListener: View.OnClickListener) {
        setupToolbar(title, activity, true, false, true, false, null, null, onSaveClickListener, null)
    }

    fun showExpandedPurpleToolbarSaveInput(title: String,
                                           activity: Activity,
                                           onSaveClickListener: View.OnClickListener,
                                           inputTextWatcher: TextWatcher) {
        setupToolbar(title, activity, true, false, true, true, null, null, onSaveClickListener, inputTextWatcher)
    }

    fun showExpandedPurpleToolbarSaveInput(title: String,
                                           activity: Activity,
                                           onSaveClickListener: View.OnClickListener) {
        setupToolbar(title, activity, true, false, true, true, null, null, onSaveClickListener, null)
    }

    private fun setupToolbar(title: String?,
                             activity: Activity,
                             isPurple: Boolean,
                             withSearch: Boolean,
                             withBack: Boolean,
                             withInput: Boolean,
                             onSearchClickListener: View.OnClickListener?,
                             onListsClickListener: View.OnClickListener?,
                             onSaveClickListener: View.OnClickListener?,
                             inputTextWatcher: TextWatcher?) {
        if (title != null)
            setTitle(title)
        setNavigationOnClickListener { v -> activity.finish() }

        if (isPurple) {
            setBackgroundColor(ContextCompat.getColor(activity, R.color.colorPrimary))
            setTitleTextColor(Color.WHITE)
            if (withBack) {
                setNavigationIcon(R.drawable.ic_back_light)
            }
        } else {
            if (withBack) {
                setNavigationIcon(R.drawable.ic_back_dark)
            }
        }

        if (!withInput && inputEdt != null)
            inputEdt!!.visibility = View.GONE

        if (inputTextWatcher != null)
            inputEdt!!.addTextChangedListener(inputTextWatcher)

        if (onSearchClickListener != null) {
            searchEdt!!.visibility = if (withSearch) View.VISIBLE else View.GONE
            searchEdt!!.setOnClickListener(onSearchClickListener)
        } else {
            searchEdt!!.visibility = View.GONE
        }

        if (onListsClickListener != null) {
            listsBtn!!.setOnClickListener(onListsClickListener)
        }

        if (onSaveClickListener != null) {
            saveBtn!!.setOnClickListener(onSaveClickListener)
        }
    }

    fun setSearchEnabled(enabled: Boolean) {
        searchEdt!!.isFocusable = enabled
        searchEdt!!.isFocusableInTouchMode = enabled
        if (enabled) {
            searchEdt!!.requestFocus()
        }
    }

    var inputText: String?
        get() {
            if (inputEdt != null)
                return inputEdt!!.text.toString()
            else
                return null
        }
        set(str) {
            if (inputEdt != null)
                inputEdt!!.setText(str)
        }
}
