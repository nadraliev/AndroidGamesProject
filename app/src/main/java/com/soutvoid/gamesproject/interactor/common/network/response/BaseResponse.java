package com.soutvoid.gamesproject.interactor.common.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

/**
 * Created by andrew on 2/21/17.
 */

@Data
public class BaseResponse {
    @SerializedName("error")
    private List<String> error;

}
