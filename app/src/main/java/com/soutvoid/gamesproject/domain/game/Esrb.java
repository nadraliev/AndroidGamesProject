
package com.soutvoid.gamesproject.domain.game;

import java.io.Serializable;
import java.lang.reflect.Field;

public class Esrb implements Serializable {

    public String synopsis;
    public Integer rating;


    public Esrb(String synopsis, Integer rating) {
        this.synopsis = synopsis;
        this.rating = rating;
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


    public String getSynopsis() {
        return this.synopsis;
    }

    public Integer getRating() {
        return this.rating;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Esrb)) return false;
        final Esrb other = (Esrb) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$synopsis = this.getSynopsis();
        final Object other$synopsis = other.getSynopsis();
        if (this$synopsis == null ? other$synopsis != null : !this$synopsis.equals(other$synopsis))
            return false;
        final Object this$rating = this.getRating();
        final Object other$rating = other.getRating();
        if (this$rating == null ? other$rating != null : !this$rating.equals(other$rating))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $synopsis = this.getSynopsis();
        result = result * PRIME + ($synopsis == null ? 43 : $synopsis.hashCode());
        final Object $rating = this.getRating();
        result = result * PRIME + ($rating == null ? 43 : $rating.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Esrb;
    }
}
