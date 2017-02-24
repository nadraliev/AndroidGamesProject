package com.soutvoid.gamesproject.interactor.genre.network.response;

import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.genre.Genre;
import com.soutvoid.gamesproject.util.Transformable;

import java.util.ArrayList;

import lombok.Data;


@Data
public class GenreObj implements Transformable<Genre> {

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
    public Genre transform() {
        return new Genre(
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
