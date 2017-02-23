package com.soutvoid.gamesproject.domain.game.enums;

/**
 * Created by andrew on 2/23/17.
 */

public enum EsrbRating {
    NO_RATING("No rating"),
    RP("RP"),
    EC("EC"),
    E("E"),
    E10PLUS("E10+"),
    T("T"),
    M("M"),
    AO("AO");

    private String s;

    private EsrbRating(String s) {
        this.s = s;
    }

    public String getValue() {
        return s;
    }
}
