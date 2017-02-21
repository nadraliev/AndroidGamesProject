package com.soutvoid.gamesproject.interactor.common.network.parse;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.soutvoid.gamesproject.interactor.common.FilterRequestFormatList;

import java.io.IOException;


/**
 * Адаптер для форматирования {@link FilterRequestFormatList} в GSON для запроса
 */
public class FilterAdapter extends TypeAdapter<FilterRequestFormatList> {

    @Override
    public void write(JsonWriter out, FilterRequestFormatList value) throws IOException {
        if (value != null) {
            out.value(value.toString());
        } else {
            out.nullValue();
        }
    }

    public FilterRequestFormatList read(JsonReader in) throws IOException {
        return null;
    }
}