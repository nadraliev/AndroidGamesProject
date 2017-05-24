package com.soutvoid.gamesproject.interactor.platform.network.response;

import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.platform.PlatformVersionReleaseDate;
import com.soutvoid.gamesproject.util.Transformable;

public class PlatformVersionReleaseDateObj implements Transformable<PlatformVersionReleaseDate> {

    @SerializedName("date")
    private Long date;
    @SerializedName("region")
    private Long region;

    public PlatformVersionReleaseDateObj() {
    }

    @Override
    public PlatformVersionReleaseDate transform() {
        return new PlatformVersionReleaseDate(
                date,
                region
        );
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
        if (!(o instanceof PlatformVersionReleaseDateObj)) return false;
        final PlatformVersionReleaseDateObj other = (PlatformVersionReleaseDateObj) o;
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
        return other instanceof PlatformVersionReleaseDateObj;
    }

    public String toString() {
        return "com.soutvoid.gamesproject.interactor.platform.network.response.PlatformVersionReleaseDateObj(date=" + this.getDate() + ", region=" + this.getRegion() + ")";
    }
}
