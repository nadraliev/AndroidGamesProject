package com.soutvoid.gamesproject.interactor.util;

import java.util.ArrayList;

/**
 * помогает строить строки с фильтром для запросов
 */
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

    private String KEY_FILTER = "filter";
    private ArrayList<String> fields = new ArrayList<>();
    private ArrayList<String> factors = new ArrayList<>();
    private ArrayList<String> values = new ArrayList<>();


    public class Builder {

        public Builder addFilter(String field, Factor factor, String value) {
            Filter.this.fields.add(field);
            Filter.this.factors.add(factor.toString());
            Filter.this.values.add(value);
            return this;

        }

        public <T extends Enum> Builder addFilter(T field, Factor factor, String value) {
            return addFilter(field.toString(), factor, value);
        }

        /**
         * @return возвращает Filter
         */
        public Filter buildMap() {
            return Filter.this;
        }
    }

}
