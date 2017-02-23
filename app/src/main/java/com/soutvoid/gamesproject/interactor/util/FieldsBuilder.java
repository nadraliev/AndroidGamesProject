package com.soutvoid.gamesproject.interactor.util;

/**
 * Created by andrew on 2/23/17.
 */

/**
 * позволяет строить строку fields для запросов
 */
public class FieldsBuilder {

    protected String fields = "";
    protected String fieldsSeparator = ",";

    public FieldsBuilder addField(String field) {
        if (!fields.equals(""))
            fields += fieldsSeparator;
        fields += field;
        return this;
    }

    public <T extends Enum> FieldsBuilder addField(T field) {
        return addField(field.toString().toLowerCase());
    }

    public FieldsBuilder addAllFields() {
        fields = "*";
        return this;
    }

    public FieldsBuilder clear() {
        fields = "";
        return this;
    }

    public String build() {
        return fields;
    }

}
