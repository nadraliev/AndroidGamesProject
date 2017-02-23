package com.soutvoid.gamesproject.domain.game.enums;

/**
 * Created by andrew on 2/23/17.
 */

public enum GameStatus {
    RELEASED("Released"),
    ALPHA("Alpha"),
    BETA("Beta"),
    EARLY_ACCESS("Early Access"),
    OFFLINE("Offline"),
    CANCELLED("Cancelled");

    private String s;

    private GameStatus(String s) {
        this.s = s;
    }

    public String getValue() {
        return s;
    }
}
