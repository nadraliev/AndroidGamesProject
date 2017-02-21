package com.soutvoid.gamesproject.interactor.game.network.response;

import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.game.AlternativeName;
import com.soutvoid.gamesproject.util.Transformable;

import lombok.Data;

/**
 * Created by andrew on 2/21/17.
 */

@Data
public class AlternativeNameObj implements Transformable<AlternativeName> {

    @SerializedName("name")
    public String name;
    @SerializedName("comment")
    public String comment;

    @Override
    public AlternativeName transform() {
        return new AlternativeName(
                name,
                comment
        );
    }
}
