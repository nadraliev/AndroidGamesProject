package com.soutvoid.gamesproject.interactor.franchise.network.response;

import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.franchise.Franchise;
import com.soutvoid.gamesproject.util.Transformable;

import java.util.ArrayList;

/**
 * Created by andrew on 2/23/17.
 */

public class FranchiseObj implements Transformable<Franchise> {

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
    public Franchise transform() {
        return new Franchise(
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
