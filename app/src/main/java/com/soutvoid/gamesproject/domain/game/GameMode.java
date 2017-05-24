package com.soutvoid.gamesproject.domain.game;

import java.io.Serializable;
import java.util.ArrayList;

public class GameMode implements Serializable {

    private Long id;
    private String name;
    private String slug;
    private String url;
    private Long createdAt;
    private Long updatedAt;
    private ArrayList<Long> games;


    public GameMode(Long id, String name, String slug, String url, Long createdAt, Long updatedAt, ArrayList<Long> games) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.url = url;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.games = games;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSlug() {
        return this.slug;
    }

    public String getUrl() {
        return this.url;
    }

    public Long getCreatedAt() {
        return this.createdAt;
    }

    public Long getUpdatedAt() {
        return this.updatedAt;
    }

    public ArrayList<Long> getGames() {
        return this.games;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setGames(ArrayList<Long> games) {
        this.games = games;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof GameMode)) return false;
        final GameMode other = (GameMode) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$slug = this.getSlug();
        final Object other$slug = other.getSlug();
        if (this$slug == null ? other$slug != null : !this$slug.equals(other$slug)) return false;
        final Object this$url = this.getUrl();
        final Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) return false;
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt))
            return false;
        final Object this$updatedAt = this.getUpdatedAt();
        final Object other$updatedAt = other.getUpdatedAt();
        if (this$updatedAt == null ? other$updatedAt != null : !this$updatedAt.equals(other$updatedAt))
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
        final Object $slug = this.getSlug();
        result = result * PRIME + ($slug == null ? 43 : $slug.hashCode());
        final Object $url = this.getUrl();
        result = result * PRIME + ($url == null ? 43 : $url.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final Object $updatedAt = this.getUpdatedAt();
        result = result * PRIME + ($updatedAt == null ? 43 : $updatedAt.hashCode());
        final Object $games = this.getGames();
        result = result * PRIME + ($games == null ? 43 : $games.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof GameMode;
    }

    public String toString() {
        return "com.soutvoid.gamesproject.domain.game.GameMode(id=" + this.getId() + ", name=" + this.getName() + ", slug=" + this.getSlug() + ", url=" + this.getUrl() + ", createdAt=" + this.getCreatedAt() + ", updatedAt=" + this.getUpdatedAt() + ", games=" + this.getGames() + ")";
    }
}
