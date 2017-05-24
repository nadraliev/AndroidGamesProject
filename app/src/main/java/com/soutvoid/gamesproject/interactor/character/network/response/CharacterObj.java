package com.soutvoid.gamesproject.interactor.character.network.response;

import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.character.Character;
import com.soutvoid.gamesproject.interactor.common.network.response.ImageObj;
import com.soutvoid.gamesproject.interactor.util.TransformUtil;
import com.soutvoid.gamesproject.util.Transformable;

import java.util.ArrayList;

/**
 * Created by andrew on 22-Feb-17.
 */

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
    @SerializedName("mug_shot")
    private ImageObj mugShot;
    @SerializedName("gender")
    private Integer gender;
    @SerializedName("akas")
    private ArrayList<String> akas;
    @SerializedName("species")
    private Integer species;
    @SerializedName("people")
    public ArrayList<Integer> people = null;
    @SerializedName("games")
    public ArrayList<Integer> games = null;

    public CharacterObj() {
    }

    @Override
    public Character transform() {
        return new Character(
                id,
                name,
                createdAt,
                updatedAt,
                slug,
                url,
                TransformUtil.INSTANCE.transform(mugShot),
                gender,
                akas,
                species,
                people,
                games
        );
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Long getCreatedAt() {
        return this.createdAt;
    }

    public Long getUpdatedAt() {
        return this.updatedAt;
    }

    public String getSlug() {
        return this.slug;
    }

    public String getUrl() {
        return this.url;
    }

    public ImageObj getMugShot() {
        return this.mugShot;
    }

    public Integer getGender() {
        return this.gender;
    }

    public ArrayList<String> getAkas() {
        return this.akas;
    }

    public Integer getSpecies() {
        return this.species;
    }

    public ArrayList<Integer> getPeople() {
        return this.people;
    }

    public ArrayList<Integer> getGames() {
        return this.games;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setMugShot(ImageObj mugShot) {
        this.mugShot = mugShot;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setAkas(ArrayList<String> akas) {
        this.akas = akas;
    }

    public void setSpecies(Integer species) {
        this.species = species;
    }

    public void setPeople(ArrayList<Integer> people) {
        this.people = people;
    }

    public void setGames(ArrayList<Integer> games) {
        this.games = games;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof CharacterObj)) return false;
        final CharacterObj other = (CharacterObj) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt))
            return false;
        final Object this$updatedAt = this.getUpdatedAt();
        final Object other$updatedAt = other.getUpdatedAt();
        if (this$updatedAt == null ? other$updatedAt != null : !this$updatedAt.equals(other$updatedAt))
            return false;
        final Object this$slug = this.getSlug();
        final Object other$slug = other.getSlug();
        if (this$slug == null ? other$slug != null : !this$slug.equals(other$slug)) return false;
        final Object this$url = this.getUrl();
        final Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) return false;
        final Object this$mugShot = this.getMugShot();
        final Object other$mugShot = other.getMugShot();
        if (this$mugShot == null ? other$mugShot != null : !this$mugShot.equals(other$mugShot))
            return false;
        final Object this$gender = this.getGender();
        final Object other$gender = other.getGender();
        if (this$gender == null ? other$gender != null : !this$gender.equals(other$gender))
            return false;
        final Object this$akas = this.getAkas();
        final Object other$akas = other.getAkas();
        if (this$akas == null ? other$akas != null : !this$akas.equals(other$akas)) return false;
        final Object this$species = this.getSpecies();
        final Object other$species = other.getSpecies();
        if (this$species == null ? other$species != null : !this$species.equals(other$species))
            return false;
        final Object this$people = this.getPeople();
        final Object other$people = other.getPeople();
        if (this$people == null ? other$people != null : !this$people.equals(other$people))
            return false;
        final Object this$games = this.getGames();
        final Object other$games = other.getGames();
        if (this$games == null ? other$games != null : !this$games.equals(other$games))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final Object $updatedAt = this.getUpdatedAt();
        result = result * PRIME + ($updatedAt == null ? 43 : $updatedAt.hashCode());
        final Object $slug = this.getSlug();
        result = result * PRIME + ($slug == null ? 43 : $slug.hashCode());
        final Object $url = this.getUrl();
        result = result * PRIME + ($url == null ? 43 : $url.hashCode());
        final Object $mugShot = this.getMugShot();
        result = result * PRIME + ($mugShot == null ? 43 : $mugShot.hashCode());
        final Object $gender = this.getGender();
        result = result * PRIME + ($gender == null ? 43 : $gender.hashCode());
        final Object $akas = this.getAkas();
        result = result * PRIME + ($akas == null ? 43 : $akas.hashCode());
        final Object $species = this.getSpecies();
        result = result * PRIME + ($species == null ? 43 : $species.hashCode());
        final Object $people = this.getPeople();
        result = result * PRIME + ($people == null ? 43 : $people.hashCode());
        final Object $games = this.getGames();
        result = result * PRIME + ($games == null ? 43 : $games.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof CharacterObj;
    }

    public String toString() {
        return "com.soutvoid.gamesproject.interactor.character.network.response.CharacterObj(id=" + this.getId() + ", name=" + this.getName() + ", createdAt=" + this.getCreatedAt() + ", updatedAt=" + this.getUpdatedAt() + ", slug=" + this.getSlug() + ", url=" + this.getUrl() + ", mugShot=" + this.getMugShot() + ", gender=" + this.getGender() + ", akas=" + this.getAkas() + ", species=" + this.getSpecies() + ", people=" + this.getPeople() + ", games=" + this.getGames() + ")";
    }
}
