package com.soutvoid.gamesproject.interactor.common.network.response;

import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.Image;
import com.soutvoid.gamesproject.util.Transformable;

import lombok.Data;

/**
 * Created by andrew on 2/21/17.
 */

@Data
public class ImageObj implements Transformable<Image> {

    @SerializedName("url")
    public String url;
    @SerializedName("cloudinary_id")
    public String cloudinaryId;
    @SerializedName("width")
    public Integer width;
    @SerializedName("height")
    public Integer height;

    @Override
    public Image transform() {
        return new Image(
                url,
                cloudinaryId,
                width,
                height
        );
    }
}
