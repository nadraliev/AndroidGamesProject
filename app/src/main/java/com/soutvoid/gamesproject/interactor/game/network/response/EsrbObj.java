package com.soutvoid.gamesproject.interactor.game.network.response;

import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.game.Esrb;
import com.soutvoid.gamesproject.util.Transformable;

import lombok.Data;

/**
 * Created by andrew on 2/21/17.
 */

@Data
public class EsrbObj implements Transformable<Esrb> {

    @SerializedName("synopsis")
    public String synopsis;
    @SerializedName("rating")
    public Integer rating;

    @Override
    public Esrb transform() {
        return new Esrb(
                synopsis,
                rating
        );
    }
}
