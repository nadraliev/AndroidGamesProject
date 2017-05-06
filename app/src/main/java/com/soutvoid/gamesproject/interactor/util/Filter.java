package com.soutvoid.gamesproject.interactor.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * помогает строить строки с фильтром для запросов
 */
public class Filter extends RealmObject {

    Filter(List<String> fields, List<String> factors, List<String> values) {
        this.fields = RealmWrapUtils.wrapStrings(fields);
        this.factors = RealmWrapUtils.wrapStrings(factors);
        this.values = RealmWrapUtils.wrapStrings(values);
    }

    public Filter() {
    }

    public static FilterBuilder builder() {
        return new FilterBuilder();
    }

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

    @Ignore
    private final String KEY_FILTER = "filter";

    private RealmList<RealmString> fields;
    private RealmList<RealmString> factors;
    private RealmList<RealmString> values;

    public Map<String, String> toMap() {
        HashMap<String, String> result = new HashMap<>();
        int numberOfElements = Math.min(Math.min(fields.size(), factors.size()), values.size());
        for (int i = 0; i < numberOfElements; i++)
            result.put(KEY_FILTER + "[" + fields.get(i).getValue() + "][" + factors.get(i).getValue() + "]", values.get(i).getValue());
        return result;
    }

    public static class FilterBuilder {
        private ArrayList<String> fields;
        private ArrayList<String> factors;
        private ArrayList<String> values;

        FilterBuilder() {
        }

        public Filter.FilterBuilder field(String field) {
            if (this.fields == null) this.fields = new ArrayList<String>();
            this.fields.add(field);
            return this;
        }

        public Filter.FilterBuilder fields(Collection<? extends String> fields) {
            if (this.fields == null) this.fields = new ArrayList<String>();
            this.fields.addAll(fields);
            return this;
        }

        public Filter.FilterBuilder clearFields() {
            if (this.fields != null)
                this.fields.clear();

            return this;
        }

        public Filter.FilterBuilder factor(String factor) {
            if (this.factors == null) this.factors = new ArrayList<String>();
            this.factors.add(factor);
            return this;
        }

        public Filter.FilterBuilder factors(Collection<? extends String> factors) {
            if (this.factors == null) this.factors = new ArrayList<String>();
            this.factors.addAll(factors);
            return this;
        }

        public Filter.FilterBuilder clearFactors() {
            if (this.factors != null)
                this.factors.clear();

            return this;
        }

        public Filter.FilterBuilder value(String value) {
            if (this.values == null) this.values = new ArrayList<String>();
            this.values.add(value);
            return this;
        }

        public Filter.FilterBuilder values(Collection<? extends String> values) {
            if (this.values == null) this.values = new ArrayList<String>();
            this.values.addAll(values);
            return this;
        }

        public Filter.FilterBuilder clearValues() {
            if (this.values != null)
                this.values.clear();

            return this;
        }

        public Filter build() {
            List<String> fields;
            switch (this.fields == null ? 0 : this.fields.size()) {
                case 0:
                    fields = java.util.Collections.emptyList();
                    break;
                case 1:
                    fields = java.util.Collections.singletonList(this.fields.get(0));
                    break;
                default:
                    fields = java.util.Collections.unmodifiableList(new ArrayList<String>(this.fields));
            }
            List<String> factors;
            switch (this.factors == null ? 0 : this.factors.size()) {
                case 0:
                    factors = java.util.Collections.emptyList();
                    break;
                case 1:
                    factors = java.util.Collections.singletonList(this.factors.get(0));
                    break;
                default:
                    factors = java.util.Collections.unmodifiableList(new ArrayList<String>(this.factors));
            }
            List<String> values;
            switch (this.values == null ? 0 : this.values.size()) {
                case 0:
                    values = java.util.Collections.emptyList();
                    break;
                case 1:
                    values = java.util.Collections.singletonList(this.values.get(0));
                    break;
                default:
                    values = java.util.Collections.unmodifiableList(new ArrayList<String>(this.values));
            }

            return new Filter(fields, factors, values);
        }

        public String toString() {
            return "com.soutvoid.gamesproject.interactor.util.Filter.FilterBuilder(fields=" + this.fields + ", factors=" + this.factors + ", values=" + this.values + ")";
        }
    }
}
