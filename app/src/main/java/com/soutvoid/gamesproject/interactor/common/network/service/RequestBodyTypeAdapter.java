package com.soutvoid.gamesproject.interactor.common.network.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Created by andrew on 2/21/17.
 */

public class RequestBodyTypeAdapter extends TypeAdapter<RequestBodyMap> {

    @Override
    public void write(JsonWriter out, RequestBodyMap value) throws IOException {

    }

    @Override
    public RequestBodyMap read(JsonReader in) throws IOException {
        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(in);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Set<Map.Entry<String, JsonElement>> entries = jsonObject.entrySet();
        RequestBodyMap result = new RequestBodyMap();
        for (Map.Entry<String, JsonElement> entry : entries) {
            String stringValue;
            JsonElement value = entry.getValue();
            if (value.isJsonPrimitive() && value.getAsJsonPrimitive().isString()) {
                stringValue = value.getAsJsonPrimitive().getAsString();
            } else {
                stringValue = value.toString();
            }
            result.put(entry.getKey(), stringValue);
        }
        return result;
    }
}
