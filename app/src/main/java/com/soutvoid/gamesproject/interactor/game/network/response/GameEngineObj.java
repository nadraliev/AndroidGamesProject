package com.soutvoid.gamesproject.interactor.game.network.response;

import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.game.GameEngine;
import com.soutvoid.gamesproject.interactor.common.network.response.ImageObj;
import com.soutvoid.gamesproject.interactor.util.TransformUtil;
import com.soutvoid.gamesproject.util.Transformable;

import java.util.ArrayList;

/**
 * Created by andrew on 2/24/17.
 */

public class GameEngineObj implements Transformable<GameEngine> {

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
    @SerializedName("logo")
    private ImageObj logo;
    @SerializedName("games")
    private ArrayList<Long> games;
    @SerializedName("companies")
    private ArrayList<Long> companies;
    @SerializedName("platforms")
    private ArrayList<Long> platforms;

    @Override
    public GameEngine transform() {
        return new GameEngine(
                id,
                name,
                slug,
                url,
                createdAt,
                updatedAt,
                TransformUtil.transform(logo),
                games,
                companies,
                platforms
        );
    }
}
