package com.soutvoid.gamesproject.interactor.platform.network.response;


import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.platform.Platform;
import com.soutvoid.gamesproject.interactor.common.network.response.ImageObj;
import com.soutvoid.gamesproject.interactor.util.TransformUtil;
import com.soutvoid.gamesproject.util.Transformable;

import java.util.ArrayList;

import lombok.Data;

@Data
public class PlatformObj implements Transformable<Platform> {

    @SerializedName("id")
    private Long id;
    @SerializedName("name")
    private String name;
    @SerializedName("slug")
    private String slug;
    @SerializedName("url")
    private String url;
    @SerializedName("created_at")
    private Long createdAt;
    @SerializedName("updated_at")
    private Long updatedAt;
    @SerializedName("logo")
    private ImageObj logo;
    @SerializedName("website")
    private String website;
    @SerializedName("summary")
    private String summary;
    @SerializedName("alternative_name")
    private String alternativeName;
    @SerializedName("generation")
    private Integer generation;
    @SerializedName("games")
    private ArrayList<Long> games;
    @SerializedName("versions")
    private ArrayList<PlatformVersionObj> versions;

    @Override
    public Platform transform() {
        return new Platform(
                id,
                name,
                slug,
                url,
                createdAt,
                updatedAt,
                TransformUtil.transform(logo),
                website,
                summary,
                alternativeName,
                generation,
                games,
                TransformUtil.transformCollection(versions)
        );
    }
}
