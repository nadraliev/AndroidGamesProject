package com.soutvoid.gamesproject.domain.enums;

/**
 * Created by andrew on 2/23/17.
 */

public enum Region {
    EUROPE("Europe"),
    NORTH_AMERICA("North america"),
    AUSTRALIA("Australia"),
    NEW_ZEALAND("New zealand"),
    JAPAN("Japan"),
    CHINA("China"),
    ASIA("Asia"),
    WORLDWIDE("Worldwide");

    private String s;

    private Region(String s) {
        this.s = s;
    }

    public String getValue() {
        return s;
    }
}
