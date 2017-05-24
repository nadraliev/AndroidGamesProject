package com.soutvoid.gamesproject.interactor.game.network.response;

import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.game.ReleaseDate;
import com.soutvoid.gamesproject.util.Transformable;

/**
 * Created by andrew on 2/21/17.
 */

public class ReleaseDateObj implements Transformable<ReleaseDate> {

    @SerializedName("category")
    public Integer category;
    @SerializedName("platform")
    public Integer platform;
    @SerializedName("date")
    public Long date;
    @SerializedName("region")
    public Integer region;
    @SerializedName("human")
    public String human;
    @SerializedName("y")
    public Integer y;
    @SerializedName("m")
    public Integer m;

    public ReleaseDateObj() {
    }

    @Override
    public ReleaseDate transform() {
        return new ReleaseDate(
                category,
                platform,
                date,
                region,
                human,
                y,
                m
        );
    }

    public Integer getCategory() {
        return this.category;
    }

    public Integer getPlatform() {
        return this.platform;
    }

    public Long getDate() {
        return this.date;
    }

    public Integer getRegion() {
        return this.region;
    }

    public String getHuman() {
        return this.human;
    }

    public Integer getY() {
        return this.y;
    }

    public Integer getM() {
        return this.m;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public void setHuman(String human) {
        this.human = human;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void setM(Integer m) {
        this.m = m;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ReleaseDateObj)) return false;
        final ReleaseDateObj other = (ReleaseDateObj) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$category = this.getCategory();
        final Object other$category = other.getCategory();
        if (this$category == null ? other$category != null : !this$category.equals(other$category))
            return false;
        final Object this$platform = this.getPlatform();
        final Object other$platform = other.getPlatform();
        if (this$platform == null ? other$platform != null : !this$platform.equals(other$platform))
            return false;
        final Object this$date = this.getDate();
        final Object other$date = other.getDate();
        if (this$date == null ? other$date != null : !this$date.equals(other$date)) return false;
        final Object this$region = this.getRegion();
        final Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region))
            return false;
        final Object this$human = this.getHuman();
        final Object other$human = other.getHuman();
        if (this$human == null ? other$human != null : !this$human.equals(other$human))
            return false;
        final Object this$y = this.getY();
        final Object other$y = other.getY();
        if (this$y == null ? other$y != null : !this$y.equals(other$y)) return false;
        final Object this$m = this.getM();
        final Object other$m = other.getM();
        if (this$m == null ? other$m != null : !this$m.equals(other$m)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $category = this.getCategory();
        result = result * PRIME + ($category == null ? 43 : $category.hashCode());
        final Object $platform = this.getPlatform();
        result = result * PRIME + ($platform == null ? 43 : $platform.hashCode());
        final Object $date = this.getDate();
        result = result * PRIME + ($date == null ? 43 : $date.hashCode());
        final Object $region = this.getRegion();
        result = result * PRIME + ($region == null ? 43 : $region.hashCode());
        final Object $human = this.getHuman();
        result = result * PRIME + ($human == null ? 43 : $human.hashCode());
        final Object $y = this.getY();
        result = result * PRIME + ($y == null ? 43 : $y.hashCode());
        final Object $m = this.getM();
        result = result * PRIME + ($m == null ? 43 : $m.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ReleaseDateObj;
    }

    public String toString() {
        return "com.soutvoid.gamesproject.interactor.game.network.response.ReleaseDateObj(category=" + this.getCategory() + ", platform=" + this.getPlatform() + ", date=" + this.getDate() + ", region=" + this.getRegion() + ", human=" + this.getHuman() + ", y=" + this.getY() + ", m=" + this.getM() + ")";
    }
}
