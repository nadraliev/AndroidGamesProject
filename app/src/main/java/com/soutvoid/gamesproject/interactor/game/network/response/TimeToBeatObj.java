package com.soutvoid.gamesproject.interactor.game.network.response;

import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.game.TimeToBeat;
import com.soutvoid.gamesproject.util.Transformable;

/**
 * Created by andrew on 2/23/17.
 */

public class TimeToBeatObj implements Transformable<TimeToBeat> {

    @SerializedName("hastly")
    private Long hastly;
    @SerializedName("normally")
    private Long normally;
    @SerializedName("completely")
    private Long completely;

    public TimeToBeatObj() {
    }

    @Override
    public TimeToBeat transform() {
        return new TimeToBeat(
                hastly,
                normally,
                completely
        );
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
        if (!(o instanceof TimeToBeatObj)) return false;
        final TimeToBeatObj other = (TimeToBeatObj) o;
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
        return other instanceof TimeToBeatObj;
    }

    public String toString() {
        return "com.soutvoid.gamesproject.interactor.game.network.response.TimeToBeatObj(hastly=" + this.getHastly() + ", normally=" + this.getNormally() + ", completely=" + this.getCompletely() + ")";
    }
}
