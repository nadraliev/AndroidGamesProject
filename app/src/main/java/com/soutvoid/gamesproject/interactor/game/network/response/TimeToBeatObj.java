package com.soutvoid.gamesproject.interactor.game.network.response;

import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.game.TimeToBeat;
import com.soutvoid.gamesproject.util.Transformable;

import lombok.Data;

/**
 * Created by andrew on 2/23/17.
 */

@Data
public class TimeToBeatObj implements Transformable<TimeToBeat> {

    @SerializedName("hastly")
    private Long hastly;
    @SerializedName("normally")
    private Long normally;
    @SerializedName("completely")
    private Long completely;

    @Override
    public TimeToBeat transform() {
        return new TimeToBeat(
                hastly,
                normally,
                completely
        );
    }
}
