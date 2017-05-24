package com.soutvoid.gamesproject.interactor.game.network.response;

import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.game.Pegi;
import com.soutvoid.gamesproject.util.Transformable;

/**
 * Created by andrew on 2/21/17.
 */

public class PegiObj implements Transformable<Pegi> {

    @SerializedName("rating")
    public Integer rating;

    public PegiObj() {
    }

    @Override
    public Pegi transform() {
        return new Pegi(
                rating
        );
    }

    public Integer getRating() {
        return this.rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof PegiObj)) return false;
        final PegiObj other = (PegiObj) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$rating = this.getRating();
        final Object other$rating = other.getRating();
        if (this$rating == null ? other$rating != null : !this$rating.equals(other$rating))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $rating = this.getRating();
        result = result * PRIME + ($rating == null ? 43 : $rating.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof PegiObj;
    }

    public String toString() {
        return "com.soutvoid.gamesproject.interactor.game.network.response.PegiObj(rating=" + this.getRating() + ")";
    }
}
