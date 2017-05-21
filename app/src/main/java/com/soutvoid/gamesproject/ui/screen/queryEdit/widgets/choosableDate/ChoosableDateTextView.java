package com.soutvoid.gamesproject.ui.screen.queryEdit.widgets.choosableDate;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.date.MonthAdapter;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

public class ChoosableDateTextView extends AppCompatTextView implements DatePickerDialog.OnDateSetListener {

    private DatePickerDialog datePickerDialog;
    private DatePickerDialog.OnDateSetListener onDateSetListener;

    private Context context;
    private boolean touched = false;

    public ChoosableDateTextView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public ChoosableDateTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        Calendar calendar = Calendar.getInstance();
        datePickerDialog = DatePickerDialog.newInstance(
                this,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        updateTextView(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        updateTextView(year, monthOfYear, dayOfMonth);

        if (onDateSetListener != null)
            onDateSetListener.onDateSet(view, year, monthOfYear, dayOfMonth);
    }

    private String getMonthForInt(int num) {
        String month = "wrong";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11) {
            month = months[num];
        }
        return month;
    }

    private void updateTextView(int year, int monthOfYear, int dayOfMonth) {
        String dateFormat = "%s %d, %s";
        setText(String.format(Locale.getDefault(), dateFormat, getMonthForInt(monthOfYear), dayOfMonth, year));
    }

    public void setOnDateSetListener(DatePickerDialog.OnDateSetListener onDateSetListener) {
        datePickerDialog.setOnDateSetListener(onDateSetListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                touched = true;
                break;
            case MotionEvent.ACTION_MOVE:
                touched = true;
                break;
            case MotionEvent.ACTION_UP:
                if (touched)
                    onClick();
                touched = false;
                break;
            case MotionEvent.ACTION_CANCEL:
                touched = false;
                break;
            case MotionEvent.ACTION_OUTSIDE:
                touched = false;
                break;
            default:
        }
        return true;
    }

    private void onClick() {
        if (isEnabled())
            showDatePicker();
    }

    private void showDatePicker() {
        if (context instanceof Activity) {
            datePickerDialog.show(((Activity) context).getFragmentManager(), getFragmentTag());
        }
    }

    /**
     * в случае, если при повороте экрана слушатели сбросятся, то нужно использовать этот метод в onResume activity
     *
     * @param onDateSetListener
     */
    public void restoreDatePickerFragment(DatePickerDialog.OnDateSetListener onDateSetListener) {
        if (context instanceof Activity) {
            datePickerDialog = (DatePickerDialog) ((Activity) context).getFragmentManager().findFragmentByTag(getFragmentTag());
            setOnDateSetListener(onDateSetListener);
        }
    }

    public String getFragmentTag() {
        return String.valueOf(this.hashCode());
    }

    /**
     * @param activity нужно для получения fragmentManager для диалога
     */
    public void setActivity(Activity activity) {
        context = activity;
    }

    public MonthAdapter.CalendarDay getSelectedDay() {
        return datePickerDialog.getSelectedDay();
    }
}
