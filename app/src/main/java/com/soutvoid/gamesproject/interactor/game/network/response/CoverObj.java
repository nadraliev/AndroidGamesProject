package com.soutvoid.gamesproject.interactor.game.network.response;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * Created by andrew on 2/21/17.
 */

@Data
public class CoverObj {

    @SerializedName("url")
    public String url;
    @SerializedName("cloudinary_id")
    public String cloudinaryId;
    @SerializedName("width")
    public Integer width;
    @SerializedName("height")
    public Integer height;

}
