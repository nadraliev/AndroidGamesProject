package com.soutvoid.gamesproject.interactor.common.network.parse;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.soutvoid.gamesproject.interactor.common.network.error.ConversionException;

import java.io.IOException;


public class StringAdapter extends TypeAdapter<String> {
    @Override
    public void write(JsonWriter out, String value) throws IOException {
        out.value(value);
    }

    @Override
    public String read(JsonReader in) throws IOException {
        JsonToken peek = in.peek();
        switch (peek) {
            case STRING:
                return in.nextString();
            case NULL:
                in.nextNull();
                return null;
            case NUMBER:
                return String.valueOf(in.nextInt());
            default:
                throw new ConversionException("Expected String but was " + peek);
        }
    }
}
