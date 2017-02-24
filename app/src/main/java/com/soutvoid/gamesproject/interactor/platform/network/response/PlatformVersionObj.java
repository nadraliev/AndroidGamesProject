package com.soutvoid.gamesproject.interactor.platform.network.response;

import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.platform.PlatformVersion;
import com.soutvoid.gamesproject.interactor.common.network.response.ImageObj;
import com.soutvoid.gamesproject.interactor.util.TransformUtil;
import com.soutvoid.gamesproject.util.Transformable;

import java.util.ArrayList;

import lombok.Data;

@Data
public class PlatformVersionObj implements Transformable<PlatformVersion> {

    @SerializedName("url")
    private String url;
    @SerializedName("name")
    private String name;
    @SerializedName("slug")
    private String slug;
    @SerializedName("cpu")
    private String cpu;
    @SerializedName("media")
    private String media;
    @SerializedName("memory")
    private String memory;
    @SerializedName("online")
    private String online;
    @SerializedName("output")
    private String output;
    @SerializedName("storage")
    private String storage;
    @SerializedName("graphics")
    private String graphics;
    @SerializedName("resolutions")
    private String resolutions;
    @SerializedName("logo")
    private ImageObj logo;
    @SerializedName("summary")
    private String summary;
    @SerializedName("release_dates")
    private ArrayList<PlatformVersionReleaseDateObj> releaseDates;

    @Override
    public PlatformVersion transform() {
        return new PlatformVersion(
                url,
                name,
                slug,
                cpu,
                media,
                memory,
                online,
                output,
                storage,
                graphics,
                resolutions,
                TransformUtil.transform(logo),
                summary,
                TransformUtil.transformCollection(releaseDates)
        );
    }
}
