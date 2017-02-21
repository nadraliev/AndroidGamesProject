package com.soutvoid.gamesproject.interactor.game.network.response;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * Created by andrew on 2/21/17.
 */

@Data
public class ReleaseDateObj {

    @SerializedName("category")
    public Integer category;
    @SerializedName("platform")
    public Integer platform;
    @SerializedName("date")
    public Integer date;
    @SerializedName("region")
    public Integer region;
    @SerializedName("human")
    public String human;
    @SerializedName("y")
    public Integer y;
    @SerializedName("m")
    public Integer m;

}
