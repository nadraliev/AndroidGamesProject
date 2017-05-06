package com.soutvoid.gamesproject.interactor.util;


import java.util.List;

import lombok.Builder;
import lombok.Singular;

/**
 * позволяет строить строку fields для запросов
 */
@Builder
public class Fields {

    @Singular
    protected List<String> fields;
    protected final String FIELDS_SEPARATOR = ",";

    /**
     * по-умолчанию добавляются все поля
     *
     * @return
     */
    @Override
    public String toString() {
        if (fields == null || fields.size() == 0)
            return "*";
        StringBuilder stringBuilder = new StringBuilder();
        fields.forEach(element -> stringBuilder.append(element).append(","));
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
