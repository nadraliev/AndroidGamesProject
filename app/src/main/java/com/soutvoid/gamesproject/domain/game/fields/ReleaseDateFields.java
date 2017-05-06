package com.soutvoid.gamesproject.domain.game.fields;

/**
 * Created by andrew on 2/23/17.
 */

public enum ReleaseDateFields {
    CATEGORY,
    PLATFORM,
    DATE,
    REGION,
    HUMAN,
    Y,
    M;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
