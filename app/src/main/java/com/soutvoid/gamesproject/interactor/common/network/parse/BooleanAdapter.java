package com.soutvoid.gamesproject.interactor.common.network.parse;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.soutvoid.gamesproject.interactor.common.network.error.ConversionException;

import java.io.IOException;


public class BooleanAdapter extends TypeAdapter<Boolean> {
    @Override
    public void write(JsonWriter out, Boolean value) throws IOException {
        out.value(value);
    }

    @Override
    public Boolean read(JsonReader in) throws IOException {
        JsonToken peek = in.peek();
        switch (peek) {
            case BOOLEAN:
                return in.nextBoolean();
            case NULL:
                in.nextNull();
                return false;
            case NUMBER:
                return in.nextInt() != 0;
            case STRING:
                return Boolean.parseBoolean(in.nextString());
            default:
                throw new ConversionException("Expected BOOLEAN but was " + peek);
        }
    }
}
