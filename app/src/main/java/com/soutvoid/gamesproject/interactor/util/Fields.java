package com.soutvoid.gamesproject.interactor.util;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * позволяет строить строку fields для запросов
 */
public class Fields extends RealmObject {

    protected RealmList<RealmString> fields;

    @Ignore
    protected final String FIELDS_SEPARATOR = ",";

    public Fields() {
    }

    Fields(List<String> fields) {
        this.fields = RealmWrapUtils.wrapStrings(fields);
    }

    public static FieldsBuilder builder() {
        return new FieldsBuilder();
    }

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
        for (RealmString string : fields)
            stringBuilder.append(string).append(",");
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public static class FieldsBuilder {
        private ArrayList<String> fields;

        FieldsBuilder() {
        }

        public Fields.FieldsBuilder field(String field) {
            if (this.fields == null) this.fields = new ArrayList<String>();
            this.fields.add(field);
            return this;
        }

        public Fields.FieldsBuilder fields(Collection<? extends String> fields) {
            if (this.fields == null) this.fields = new ArrayList<String>();
            this.fields.addAll(fields);
            return this;
        }

        public Fields.FieldsBuilder clearFields() {
            if (this.fields != null)
                this.fields.clear();

            return this;
        }

        public Fields build() {
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

            return new Fields(fields);
        }

        public String toString() {
            return "com.soutvoid.gamesproject.interactor.util.Fields.FieldsBuilder(fields=" + this.fields + ")";
        }
    }
}
