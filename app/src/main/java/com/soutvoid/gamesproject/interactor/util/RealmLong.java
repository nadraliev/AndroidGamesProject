package com.soutvoid.gamesproject.interactor.util;

import io.realm.RealmObject;

public class RealmLong extends RealmObject {
    private long value;


    public RealmLong(long value) {
        this.value = value;
    }

    public RealmLong() {
    }

    public long getValue() {
        return this.value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public String toString() {
        return "com.soutvoid.gamesproject.interactor.util.RealmLong(value=" + this.getValue() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof RealmLong)) return false;
        final RealmLong other = (RealmLong) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getValue() != other.getValue()) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $value = this.getValue();
        result = result * PRIME + (int) ($value >>> 32 ^ $value);
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof RealmLong;
    }
}
