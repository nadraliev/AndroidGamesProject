package com.soutvoid.gamesproject.interactor.common.network.parse.safe;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.soutvoid.gamesproject.interactor.common.network.parse.ResponseTypeAdapterFactory;


public abstract class SafeConverter<T> {

    private TypeToken<T> type;

    public SafeConverter(TypeToken<T> type) {
        this.type = type;
    }

    public TypeToken<T> getType() {
        return type;
    }

    public abstract T convert(ResponseTypeAdapterFactory responseTypeAdapterFactory, Gson gson, JsonElement element);

}
