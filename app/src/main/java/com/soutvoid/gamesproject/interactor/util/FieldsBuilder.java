package com.soutvoid.gamesproject.interactor.util;

/**
 * Created by andrew on 2/23/17.
 */

public class FieldsBuilder {

    private String fields = "";
    private String fieldsSeparator = ",";

    public FieldsBuilder addField(String field) {
        if (!fields.equals(""))
            fields += fieldsSeparator;
        fields += field;
        return this;
    }

    public <T extends Enum> FieldsBuilder addField(T field) {
        return addField(field.toString());
    }

}
