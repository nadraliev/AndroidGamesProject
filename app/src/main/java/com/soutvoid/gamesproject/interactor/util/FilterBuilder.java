package com.soutvoid.gamesproject.interactor.util;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

/**
 * помогает строить строки с фильтром для запросов
 */
public class FilterBuilder {

    /**
     * дроступные факторы сортировки
     */
    public enum Factor {
        /**
         * равно значению
         */
        eq,
        /**
         * не равно значению
         */
        not_eq,
        /**
         * строго больше значения
         */
        gt,
        /**
         * больше или равно значению
         */
        gte,
        /**
         * строго меньше значения
         */
        lt,
        /**
         * меньше или равно значению
         */
        lte,
        /**
         * строка начинается со значения
         */
        prefix,
        /**
         * значение существует
         */
        exists,
        /**
         * значение не существует
         */
        not_exists,
        /**
         * значение присутсвует в массиве
         */
        in
    }

    private String KEY_FILTER = "filter";
    private String field = "";
    private String factor = "";
    private String value = "";

    /**
     * устанавливает поле, по которому необходимо сортировать
     */
    public FilterBuilder setField(String field) {
        this.field = field;
        return this;
    }

    /**
     * то же, что и {@link #setField(String)}, но принимает елемент enum
     */
    public <T extends Enum> FilterBuilder setField(T field) {
        return setField(field.toString().toLowerCase());
    }

    /**
     * устанавливает фактор сортировки из {@link Factor}
     *
     * @param factor
     * @return
     */
    public FilterBuilder setFactor(Factor factor) {
        this.factor = factor.toString();
        return this;
    }

    /**
     * устанавливает значение для сортировки по нему
     * @param value
     * @return
     */
    public FilterBuilder setValue(String value) {
        this.value = value;
        return this;
    }

    /**
     * @return возвращает поле для Map для сообщения в QueryMap
     */
    public Map.Entry<String, String> buildMapEntry() {
        return new AbstractMap.SimpleEntry<>(KEY_FILTER + "[" + field + "][" + factor + "]", value);
    }

    public HashMap<String, String> buildMap() {
        HashMap<String, String> result = new HashMap<>();
        result.put(KEY_FILTER + "[" + field + "][" + factor + "]", value);
        return result;
    }

    public FilterBuilder clear() {
        field = "";
        factor = "";
        value = "";
        return this;
    }

}
