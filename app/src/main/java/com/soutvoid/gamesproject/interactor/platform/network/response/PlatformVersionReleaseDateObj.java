package com.soutvoid.gamesproject.interactor.platform.network.response;

import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.platform.PlatformVersionReleaseDate;
import com.soutvoid.gamesproject.util.Transformable;

import lombok.Data;

@Data
public class PlatformVersionReleaseDateObj implements Transformable<PlatformVersionReleaseDate> {

    @SerializedName("date")
    private Long date;
    @SerializedName("region")
    private Long region;

    @Override
    public PlatformVersionReleaseDate transform() {
        return new PlatformVersionReleaseDate(
                date,
                region
        );
    }
}
