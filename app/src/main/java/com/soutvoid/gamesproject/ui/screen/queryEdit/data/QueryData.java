package com.soutvoid.gamesproject.ui.screen.queryEdit.data;

import com.wdullaer.materialdatetimepicker.date.MonthAdapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryData {

    private String name;
    private MonthAdapter.CalendarDay releasedFrom;
    private MonthAdapter.CalendarDay releasedTo;

}
