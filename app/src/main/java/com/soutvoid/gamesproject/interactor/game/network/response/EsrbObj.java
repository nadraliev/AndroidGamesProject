package com.soutvoid.gamesproject.interactor.game.network.response;

import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.game.Esrb;
import com.soutvoid.gamesproject.util.Transformable;

/**
 * Created by andrew on 2/21/17.
 */

public class EsrbObj implements Transformable<Esrb> {

    @SerializedName("synopsis")
    public String synopsis;
    @SerializedName("rating")
    public Integer rating;

    public EsrbObj() {
    }

    @Override
    public Esrb transform() {
        return new Esrb(
                synopsis,
                rating
        );
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
        if (!(o instanceof EsrbObj)) return false;
        final EsrbObj other = (EsrbObj) o;
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
        return other instanceof EsrbObj;
    }

    public String toString() {
        return "com.soutvoid.gamesproject.interactor.game.network.response.EsrbObj(synopsis=" + this.getSynopsis() + ", rating=" + this.getRating() + ")";
    }
}
