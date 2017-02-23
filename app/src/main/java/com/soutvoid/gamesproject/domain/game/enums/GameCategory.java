package com.soutvoid.gamesproject.domain.game.enums;

/**
 * Created by andrew on 2/23/17.
 */

public enum GameCategory {
    MAIN_GAME("Main game"),
    DLC("DLC/Addon"),
    EXPANSION("Expansion"),
    BUNDLE("Bundle"),
    STANDALONE_EXPANSION("Standalone expansion");

    private String s;

    private GameCategory(String s) {
        this.s = s;
    }

    public String getValue() {
        return s;
    }
}
