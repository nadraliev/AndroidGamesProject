package com.soutvoid.gamesproject.ui.screen.queryEdit.data;

import com.wdullaer.materialdatetimepicker.date.MonthAdapter;

import java.util.List;

public class QueryData {

    private String name;
    private MonthAdapter.CalendarDay releasedFrom;
    private MonthAdapter.CalendarDay releasedTo;
    private List<Integer> selectedGenres;


    public QueryData(String name, MonthAdapter.CalendarDay releasedFrom, MonthAdapter.CalendarDay releasedTo, List<Integer> selectedGenres) {
        this.name = name;
        this.releasedFrom = releasedFrom;
        this.releasedTo = releasedTo;
        this.selectedGenres = selectedGenres;
    }

    public QueryData() {
    }

    public String getName() {
        return this.name;
    }

    public MonthAdapter.CalendarDay getReleasedFrom() {
        return this.releasedFrom;
    }

    public MonthAdapter.CalendarDay getReleasedTo() {
        return this.releasedTo;
    }

    public List<Integer> getSelectedGenres() {
        return this.selectedGenres;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleasedFrom(MonthAdapter.CalendarDay releasedFrom) {
        this.releasedFrom = releasedFrom;
    }

    public void setReleasedTo(MonthAdapter.CalendarDay releasedTo) {
        this.releasedTo = releasedTo;
    }

    public void setSelectedGenres(List<Integer> selectedGenres) {
        this.selectedGenres = selectedGenres;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof QueryData)) return false;
        final QueryData other = (QueryData) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$releasedFrom = this.getReleasedFrom();
        final Object other$releasedFrom = other.getReleasedFrom();
        if (this$releasedFrom == null ? other$releasedFrom != null : !this$releasedFrom.equals(other$releasedFrom))
            return false;
        final Object this$releasedTo = this.getReleasedTo();
        final Object other$releasedTo = other.getReleasedTo();
        if (this$releasedTo == null ? other$releasedTo != null : !this$releasedTo.equals(other$releasedTo))
            return false;
        final Object this$selectedGenres = this.getSelectedGenres();
        final Object other$selectedGenres = other.getSelectedGenres();
        if (this$selectedGenres == null ? other$selectedGenres != null : !this$selectedGenres.equals(other$selectedGenres))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $releasedFrom = this.getReleasedFrom();
        result = result * PRIME + ($releasedFrom == null ? 43 : $releasedFrom.hashCode());
        final Object $releasedTo = this.getReleasedTo();
        result = result * PRIME + ($releasedTo == null ? 43 : $releasedTo.hashCode());
        final Object $selectedGenres = this.getSelectedGenres();
        result = result * PRIME + ($selectedGenres == null ? 43 : $selectedGenres.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof QueryData;
    }

    public String toString() {
        return "com.soutvoid.gamesproject.ui.screen.queryEdit.data.QueryData(name=" + this.getName() + ", releasedFrom=" + this.getReleasedFrom() + ", releasedTo=" + this.getReleasedTo() + ", selectedGenres=" + this.getSelectedGenres() + ")";
    }
}
