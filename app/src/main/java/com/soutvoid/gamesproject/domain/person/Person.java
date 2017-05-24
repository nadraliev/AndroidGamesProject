package com.soutvoid.gamesproject.domain.person;


import com.soutvoid.gamesproject.domain.Image;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable {

    private Integer id;
    private String name;
    private Long createdAt;
    private Long updatedAt;
    private String slug;
    private String url;
    private Image mugShot;
    private ArrayList<Integer> characters;
    private ArrayList<Integer> games;
    private ArrayList<Integer> voiceActed;


    public Person(Integer id, String name, Long createdAt, Long updatedAt, String slug, String url, Image mugShot, ArrayList<Integer> characters, ArrayList<Integer> games, ArrayList<Integer> voiceActed) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.slug = slug;
        this.url = url;
        this.mugShot = mugShot;
        this.characters = characters;
        this.games = games;
        this.voiceActed = voiceActed;
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

    public Image getMugShot() {
        return this.mugShot;
    }

    public ArrayList<Integer> getCharacters() {
        return this.characters;
    }

    public ArrayList<Integer> getGames() {
        return this.games;
    }

    public ArrayList<Integer> getVoiceActed() {
        return this.voiceActed;
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

    public void setMugShot(Image mugShot) {
        this.mugShot = mugShot;
    }

    public void setCharacters(ArrayList<Integer> characters) {
        this.characters = characters;
    }

    public void setGames(ArrayList<Integer> games) {
        this.games = games;
    }

    public void setVoiceActed(ArrayList<Integer> voiceActed) {
        this.voiceActed = voiceActed;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Person)) return false;
        final Person other = (Person) o;
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
        final Object this$characters = this.getCharacters();
        final Object other$characters = other.getCharacters();
        if (this$characters == null ? other$characters != null : !this$characters.equals(other$characters))
            return false;
        final Object this$games = this.getGames();
        final Object other$games = other.getGames();
        if (this$games == null ? other$games != null : !this$games.equals(other$games))
            return false;
        final Object this$voiceActed = this.getVoiceActed();
        final Object other$voiceActed = other.getVoiceActed();
        if (this$voiceActed == null ? other$voiceActed != null : !this$voiceActed.equals(other$voiceActed))
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
        final Object $characters = this.getCharacters();
        result = result * PRIME + ($characters == null ? 43 : $characters.hashCode());
        final Object $games = this.getGames();
        result = result * PRIME + ($games == null ? 43 : $games.hashCode());
        final Object $voiceActed = this.getVoiceActed();
        result = result * PRIME + ($voiceActed == null ? 43 : $voiceActed.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Person;
    }

    public String toString() {
        return "com.soutvoid.gamesproject.domain.person.Person(id=" + this.getId() + ", name=" + this.getName() + ", createdAt=" + this.getCreatedAt() + ", updatedAt=" + this.getUpdatedAt() + ", slug=" + this.getSlug() + ", url=" + this.getUrl() + ", mugShot=" + this.getMugShot() + ", characters=" + this.getCharacters() + ", games=" + this.getGames() + ", voiceActed=" + this.getVoiceActed() + ")";
    }
}
