package com.soutvoid.gamesproject.ui.util;

import com.wdullaer.materialdatetimepicker.date.MonthAdapter;

import java.util.Calendar;

public class CalendarUtils {

    public static int compareCalendarDays(MonthAdapter.CalendarDay first, MonthAdapter.CalendarDay second) {
        if (first.getYear() > second.getYear())
            return 1;
        else if (first.getYear() < second.getYear())
            return -1;
        else {
            if (first.getMonth() > second.getMonth())
                return 1;
            else if (first.getMonth() < second.getMonth())
                return -1;
            else {
                if (first.getDay() > second.getDay())
                    return 1;
                else if (first.getDay() < second.getDay())
                    return -1;
                else return 0;
            }
        }
    }

    public static long getCalendarDayInMillis(MonthAdapter.CalendarDay calendarDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendarDay.getYear());
        calendar.set(Calendar.MONTH, calendarDay.getMonth());
        calendar.set(Calendar.DAY_OF_MONTH, calendarDay.getDay());
        return calendar.getTimeInMillis();
    }

}
