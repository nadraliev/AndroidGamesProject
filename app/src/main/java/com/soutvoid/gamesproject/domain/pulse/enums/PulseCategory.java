package com.soutvoid.gamesproject.domain.pulse.enums;

/**
 * Created by andrew on 2/23/17.
 */

public enum PulseCategory {
    REDDIT("Reddit"),
    KICKSTARTER("Kickstarter"),
    KOTAKU("Kotaku"),
    POLYGON("Polygon"),
    KILL_SCREEN("KillScreen"),
    GAME_INFORMER("GameInformer"),
    ROCK_PAPER_SHOTGUN("Rock, Paper, Shotgun"),
    WIRED_GAME("Wired Game/Life"),
    N4G("N4G"),
    ESCAPIST("Escapist"),
    PCGAMER("PCGamer"),
    IGN("IGN"),
    INDIE_GAMES("Indie Games"),
    DESTRUCTOID("Destructoid"),
    NICHE_GAMER("Niche Gamer");

    private String s;

    private PulseCategory(String s) {
        this.s = s;
    }

    public String getValue() {
        return s;
    }
}
