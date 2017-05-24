package com.soutvoid.gamesproject.domain.platform;

import java.io.Serializable;

public class PlatformVersionReleaseDate implements Serializable {

    private Long date;
    private Long region;


    public PlatformVersionReleaseDate(Long date, Long region) {
        this.date = date;
        this.region = region;
    }

    public Long getDate() {
        return this.date;
    }

    public Long getRegion() {
        return this.region;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public void setRegion(Long region) {
        this.region = region;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof PlatformVersionReleaseDate)) return false;
        final PlatformVersionReleaseDate other = (PlatformVersionReleaseDate) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$date = this.getDate();
        final Object other$date = other.getDate();
        if (this$date == null ? other$date != null : !this$date.equals(other$date)) return false;
        final Object this$region = this.getRegion();
        final Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $date = this.getDate();
        result = result * PRIME + ($date == null ? 43 : $date.hashCode());
        final Object $region = this.getRegion();
        result = result * PRIME + ($region == null ? 43 : $region.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof PlatformVersionReleaseDate;
    }

    public String toString() {
        return "com.soutvoid.gamesproject.domain.platform.PlatformVersionReleaseDate(date=" + this.getDate() + ", region=" + this.getRegion() + ")";
    }
}
