package com.soutvoid.gamesproject.domain.enums;


public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    UNKNOWN("Unknown");

    private String s;

    private Gender(String s) {
        this.s = s;
    }

    public String getValue() {
        return s;
    }
}
