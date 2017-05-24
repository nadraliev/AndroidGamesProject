package com.soutvoid.gamesproject.domain.game;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * Created by andrew on 2/23/17.
 */

public class TimeToBeat implements Serializable {

    private Long hastly;
    private Long normally;
    private Long completely;


    public TimeToBeat(Long hastly, Long normally, Long completely) {
        this.hastly = hastly;
        this.normally = normally;
        this.completely = completely;
    }

    @Override
    public String toString() {
        String result = "";
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field :
                fields) {
            try {
                result += field.getName() + ": " + field.get(this).toString() + "\n";
            } catch (IllegalAccessException | NullPointerException e) {
                //ignore
            }
        }
        return result;
    }

    public Long getHastly() {
        return this.hastly;
    }

    public Long getNormally() {
        return this.normally;
    }

    public Long getCompletely() {
        return this.completely;
    }

    public void setHastly(Long hastly) {
        this.hastly = hastly;
    }

    public void setNormally(Long normally) {
        this.normally = normally;
    }

    public void setCompletely(Long completely) {
        this.completely = completely;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof TimeToBeat)) return false;
        final TimeToBeat other = (TimeToBeat) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$hastly = this.getHastly();
        final Object other$hastly = other.getHastly();
        if (this$hastly == null ? other$hastly != null : !this$hastly.equals(other$hastly))
            return false;
        final Object this$normally = this.getNormally();
        final Object other$normally = other.getNormally();
        if (this$normally == null ? other$normally != null : !this$normally.equals(other$normally))
            return false;
        final Object this$completely = this.getCompletely();
        final Object other$completely = other.getCompletely();
        if (this$completely == null ? other$completely != null : !this$completely.equals(other$completely))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $hastly = this.getHastly();
        result = result * PRIME + ($hastly == null ? 43 : $hastly.hashCode());
        final Object $normally = this.getNormally();
        result = result * PRIME + ($normally == null ? 43 : $normally.hashCode());
        final Object $completely = this.getCompletely();
        result = result * PRIME + ($completely == null ? 43 : $completely.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof TimeToBeat;
    }
}
