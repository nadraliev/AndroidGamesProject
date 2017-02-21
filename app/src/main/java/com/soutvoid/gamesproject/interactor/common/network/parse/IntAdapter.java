package com.soutvoid.gamesproject.interactor.common.network.parse;

import android.text.TextUtils;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.soutvoid.gamesproject.interactor.common.network.error.ConversionException;

import java.io.IOException;

public class IntAdapter extends TypeAdapter<Integer> {
    @Override
    public void write(JsonWriter out, Integer value) throws IOException {
        out.value(value);
    }

    @Override
    public Integer read(JsonReader in) throws IOException {
        JsonToken peek = in.peek();
        switch (peek) {
            case NUMBER:
                return in.nextInt();
            case NULL:
                in.nextNull();
                return 0;
            case STRING:
                String next = in.nextString();
                try {
                    return TextUtils.isEmpty(next) ? 0 : Integer.parseInt(next);
                } catch (NumberFormatException e) {
                    throw new ConversionException(e.getMessage(), e);
                }
            default:
                throw new ConversionException("Expected Int but was " + peek);
        }
    }
}
