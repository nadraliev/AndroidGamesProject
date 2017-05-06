package com.soutvoid.gamesproject.domain.collection.fields;

public enum CollectionFields {
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
