package com.soutvoid.gamesproject.interactor.util;

import io.realm.RealmObject;

public class RealmString extends RealmObject {
    private String value;


    public RealmString(String value) {
        this.value = value;
    }

    public RealmString() {
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString() {
        return "com.soutvoid.gamesproject.interactor.util.RealmString(value=" + this.getValue() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof RealmString)) return false;
        final RealmString other = (RealmString) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$value = this.getValue();
        final Object other$value = other.getValue();
        if (this$value == null ? other$value != null : !this$value.equals(other$value))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $value = this.getValue();
        result = result * PRIME + ($value == null ? 43 : $value.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof RealmString;
    }
}
