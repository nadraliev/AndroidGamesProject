package com.soutvoid.gamesproject.interactor.person.network.response;


import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.person.Person;
import com.soutvoid.gamesproject.interactor.common.network.response.ImageObj;
import com.soutvoid.gamesproject.interactor.util.TransformUtil;
import com.soutvoid.gamesproject.util.Transformable;

import java.util.ArrayList;

import lombok.Data;

@Data
public class PersonObj implements Transformable<Person> {

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
    @SerializedName("mug_shot")
    private ImageObj mugShot;
    @SerializedName("characters")
    public ArrayList<Integer> characters;
    @SerializedName("games")
    public ArrayList<Integer> games;
    @SerializedName("voice_acted")
    public ArrayList<Integer> voiceActed;

    @Override
    public Person transform() {
        return new Person(
                id,
                name,
                createdAt,
                updatedAt,
                slug,
                url,
                TransformUtil.transform(mugShot),
                characters,
                games,
                voiceActed
        );
    }

}
