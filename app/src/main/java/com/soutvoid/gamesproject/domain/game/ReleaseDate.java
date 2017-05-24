
package com.soutvoid.gamesproject.domain.game;

import java.io.Serializable;
import java.lang.reflect.Field;

public class ReleaseDate implements Serializable {

    public Integer category;
    public Integer platform;
    public Long date;
    public Integer region;
    public String human;
    public Integer y;
    public Integer m;


    public ReleaseDate(Integer category, Integer platform, Long date, Integer region, String human, Integer y, Integer m) {
        this.category = category;
        this.platform = platform;
        this.date = date;
        this.region = region;
        this.human = human;
        this.y = y;
        this.m = m;
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
        if (!(o instanceof ReleaseDate)) return false;
        final ReleaseDate other = (ReleaseDate) o;
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
        return other instanceof ReleaseDate;
    }
}
