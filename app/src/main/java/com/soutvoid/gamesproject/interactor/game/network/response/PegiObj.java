package com.soutvoid.gamesproject.interactor.game.network.response;

import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.game.Pegi;
import com.soutvoid.gamesproject.util.Transformable;

import lombok.Data;

/**
 * Created by andrew on 2/21/17.
 */

@Data
public class PegiObj implements Transformable<Pegi> {

    @SerializedName("rating")
    public Integer rating;

    @Override
    public Pegi transform() {
        return new Pegi(
                rating
        );
    }
}
