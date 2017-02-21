package com.soutvoid.gamesproject.interactor.common.network.parse.safe;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.soutvoid.gamesproject.interactor.common.network.parse.ResponseTypeAdapterFactory;


public class PrimitiveToNullSafeConverter<T> extends SafeConverter<T> {

    public PrimitiveToNullSafeConverter(TypeToken<T> type) {
        super(type);
    }

    @Override
    public T convert(ResponseTypeAdapterFactory typeAdapterFactory, Gson gson, JsonElement element) {
        if (element.isJsonPrimitive()) {
            return null;
        } else {
            return gson.getDelegateAdapter(typeAdapterFactory, getType()).fromJsonTree(element);
        }
    }
}
