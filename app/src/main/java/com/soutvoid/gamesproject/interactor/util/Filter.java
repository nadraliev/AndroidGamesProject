package com.soutvoid.gamesproject.interactor.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Singular;

/**
 * помогает строить строки с фильтром для запросов
 */
@Builder
public class Filter {

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

    private final String KEY_FILTER = "filter";
    @Singular
    private List<String> fields;
    @Singular
    private List<String> factors;
    @Singular
    private List<String> values;

    public Map<String, String> toMap() {
        HashMap<String, String> result = new HashMap<>();
        int numberOfElements = Math.min(Math.min(fields.size(), factors.size()), values.size());
        for (int i = 0; i < numberOfElements; i++)
            result.put(KEY_FILTER + "[" + fields.get(i) + "][" + factors.get(i) + "]", values.get(i));
        return result;
    }

}
