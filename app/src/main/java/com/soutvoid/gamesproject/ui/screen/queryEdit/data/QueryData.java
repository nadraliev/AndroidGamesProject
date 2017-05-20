package com.soutvoid.gamesproject.ui.screen.queryEdit.data;

import com.wdullaer.materialdatetimepicker.date.MonthAdapter;

import java.util.List;

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
    private List<Integer> selectedGenres;

}
