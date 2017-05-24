package com.soutvoid.gamesproject.interactor.collection.network.response;

import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.collection.Collection;
import com.soutvoid.gamesproject.interactor.game.network.response.GameObj;
import com.soutvoid.gamesproject.interactor.util.TransformUtil;
import com.soutvoid.gamesproject.util.Transformable;

import java.util.ArrayList;

/**
 * Created by andrew on 2/23/17.
 */

public class CollectionObj implements Transformable<Collection> {

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
    private ArrayList<GameObj> games;

    @Override
    public Collection transform() {
        return new Collection(
                id,
                name,
                slug,
                url,
                createdAt,
                updatedAt,
                TransformUtil.INSTANCE.transformCollection(games)
        );
    }
}
