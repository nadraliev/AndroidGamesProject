package com.soutvoid.gamesproject.domain.game.fields;

/**
 * Created by andrew on 2/23/17.
 */

public enum TimeToBeatFields {
    HASTLY,
    NORMALLY,
    COMPLETELY;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
