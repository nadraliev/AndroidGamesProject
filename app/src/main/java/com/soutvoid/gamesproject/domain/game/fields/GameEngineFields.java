package com.soutvoid.gamesproject.domain.game.fields;



public enum GameEngineFields {
    ID,
    NAME,
    SLUG,
    URL,
    CREATED_AT,
    UPDATED_AT,
    LOGO,
    GAMES,
    COMPANIES,
    PLATFORMS;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
