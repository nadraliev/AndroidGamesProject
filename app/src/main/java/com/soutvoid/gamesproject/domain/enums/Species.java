package com.soutvoid.gamesproject.domain.enums;

/**
 * Created by andrew on 2/23/17.
 */

public enum Species {
    HUMAN("Human"),
    ALIEN("Alien"),
    ANIMAL("Animal"),
    ANDROID("Android"),
    UNKNOWN("Unknown");

    private String s;

    private Species(String s) {
        this.s = s;
    }

    public String getValue() {
        return s;
    }
}
