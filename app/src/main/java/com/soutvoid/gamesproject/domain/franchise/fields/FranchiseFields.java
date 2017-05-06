package com.soutvoid.gamesproject.domain.franchise.fields;

/**
 * Created by andrew on 2/23/17.
 */

public enum FranchiseFields {
    ID,
    NAME,
    SLUG,
    URL,
    CREATED_AT,
    UPDATED_AT,
    GAMES;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
