package com.soutvoid.gamesproject.interactor.character.network.response;

import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.character.Character;
import com.soutvoid.gamesproject.util.Transformable;

import java.util.ArrayList;

import lombok.Data;

/**
 * Created by andrew on 22-Feb-17.
 */

@Data
public class CharacterObj implements Transformable<Character> {

    @SerializedName("id")
    public Integer id;
    @SerializedName("name")
    public String name;
    @SerializedName("created_at")
    public Long createdAt;
    @SerializedName("updated_at")
    public Long updatedAt;
    @SerializedName("slug")
    public String slug;
    @SerializedName("url")
    public String url;
    @SerializedName("people")
    public ArrayList<Integer> people = null;
    @SerializedName("games")
    public ArrayList<Integer> games = null;

    @Override
    public Character transform() {
        return new Character(
                id,
                name,
                createdAt,
                updatedAt,
                slug,
                url,
                people,
                games
        );
    }
}
