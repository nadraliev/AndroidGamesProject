package com.soutvoid.gamesproject.domain.game.fields;


public enum GameFields {
    ID,
    NAME,
    SLUG,
    URL,
    CREATED_AT,
    UPDATED_AT,
    SUMMARY,
    STORYLINE,
    COLLECTION,
    FRANCHISE,
    HYPES,
    RATING,
    POPULARITY,
    AGGREGATED_RATING,
    RATING_COUNT,
    GAME,
    DEVELOPERS,
    PUBLISHERS,
    GAME_ENGINES,
    CATEGORY,
    TIME_TO_BEAT,
    PLAYER_PERSPECTIVES,
    GAME_MODES,
    KEYWORDS,
    THEMES,
    GENRES,
    FIRST_RELEASE_DATE,
    STATUS,
    RELEASE_DATES,
    ALTERNATIVE_NAMES,
    SCREENSHOTS,
    VIDEOS,
    COVER,
    ESRB,
    PEGI;


    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
