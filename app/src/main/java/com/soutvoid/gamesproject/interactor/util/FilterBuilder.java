package com.soutvoid.gamesproject.interactor.util;

import java.util.AbstractMap;
import java.util.Map;

/**
 * помогает строить строки с фильтром для запросов
 */
public class FilterBuilder {

    public enum Factor {
        eq,
        not_eq,
        gt,
        gte,
        lt,
        lte,
        prefix,
        exists,
        not_exists,
        in
    }

    private String KEY_FILTER = "filter";
    private String field = "";
    private String factor = "";
    private String value = "";

    public FilterBuilder setField(String field) {
        this.field = field;
        return this;
    }

    public <T extends Enum> FilterBuilder setField(T field) {
        return setField(field.toString());
    }

    public FilterBuilder setFactor(Factor factor) {
        this.factor = factor.toString();
        return this;
    }

    public FilterBuilder setValue(String value) {
        this.value = value;
        return this;
    }

    /**
     * @return возвращает поле для Map для сообщения в QueryMap
     */
    public Map.Entry<String, String> build() {
        return new AbstractMap.SimpleEntry<>(KEY_FILTER + "[" + field + "][" + factor + "]", value);
    }

    public FilterBuilder clear() {
        field = "";
        factor = "";
        value = "";
        return this;
    }

}
