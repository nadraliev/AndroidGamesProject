package com.soutvoid.gamesproject.interactor.game.network.response;

import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.game.GameMode;
import com.soutvoid.gamesproject.util.Transformable;

import java.util.ArrayList;

import lombok.Data;

/**
 * Created by andrew on 2/24/17.
 */

@Data
public class GameModeObj implements Transformable<GameMode> {

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
    @SerializedName("games")
    private ArrayList<Long> games;

    @Override
    public GameMode transform() {
        return new GameMode(
                id,
                name,
                slug,
                url,
                createdAt,
                updatedAt,
                games
        );
    }

}
