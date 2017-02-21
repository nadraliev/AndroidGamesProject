package com.soutvoid.gamesproject.interactor.game.network.response;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * Created by andrew on 2/21/17.
 */

@Data
public class EsrbObj {

    @SerializedName("synopsis")
    public String synopsis;
    @SerializedName("rating")
    public Integer rating;

}
