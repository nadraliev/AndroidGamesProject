package com.soutvoid.gamesproject.domain.platform;


import com.soutvoid.gamesproject.domain.Image;

import java.io.Serializable;
import java.util.ArrayList;

public class Platform implements Serializable {

    private Long id;
    private String name;
    private String slug;
    private String url;
    private Long createdAt;
    private Long updatedAt;
    private Image logo;
    private String website;
    private String summary;
    private String alternativeName;
    private Integer generation;
    private ArrayList<Long> games;
    private ArrayList<PlatformVersion> versions;


    public Platform(Long id, String name, String slug, String url, Long createdAt, Long updatedAt, Image logo, String website, String summary, String alternativeName, Integer generation, ArrayList<Long> games, ArrayList<PlatformVersion> versions) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.url = url;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.logo = logo;
        this.website = website;
        this.summary = summary;
        this.alternativeName = alternativeName;
        this.generation = generation;
        this.games = games;
        this.versions = versions;
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

    public Image getLogo() {
        return this.logo;
    }

    public String getWebsite() {
        return this.website;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getAlternativeName() {
        return this.alternativeName;
    }

    public Integer getGeneration() {
        return this.generation;
    }

    public ArrayList<Long> getGames() {
        return this.games;
    }

    public ArrayList<PlatformVersion> getVersions() {
        return this.versions;
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

    public void setLogo(Image logo) {
        this.logo = logo;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setAlternativeName(String alternativeName) {
        this.alternativeName = alternativeName;
    }

    public void setGeneration(Integer generation) {
        this.generation = generation;
    }

    public void setGames(ArrayList<Long> games) {
        this.games = games;
    }

    public void setVersions(ArrayList<PlatformVersion> versions) {
        this.versions = versions;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Platform)) return false;
        final Platform other = (Platform) o;
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
        final Object this$logo = this.getLogo();
        final Object other$logo = other.getLogo();
        if (this$logo == null ? other$logo != null : !this$logo.equals(other$logo)) return false;
        final Object this$website = this.getWebsite();
        final Object other$website = other.getWebsite();
        if (this$website == null ? other$website != null : !this$website.equals(other$website))
            return false;
        final Object this$summary = this.getSummary();
        final Object other$summary = other.getSummary();
        if (this$summary == null ? other$summary != null : !this$summary.equals(other$summary))
            return false;
        final Object this$alternativeName = this.getAlternativeName();
        final Object other$alternativeName = other.getAlternativeName();
        if (this$alternativeName == null ? other$alternativeName != null : !this$alternativeName.equals(other$alternativeName))
            return false;
        final Object this$generation = this.getGeneration();
        final Object other$generation = other.getGeneration();
        if (this$generation == null ? other$generation != null : !this$generation.equals(other$generation))
            return false;
        final Object this$games = this.getGames();
        final Object other$games = other.getGames();
        if (this$games == null ? other$games != null : !this$games.equals(other$games))
            return false;
        final Object this$versions = this.getVersions();
        final Object other$versions = other.getVersions();
        if (this$versions == null ? other$versions != null : !this$versions.equals(other$versions))
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
        final Object $logo = this.getLogo();
        result = result * PRIME + ($logo == null ? 43 : $logo.hashCode());
        final Object $website = this.getWebsite();
        result = result * PRIME + ($website == null ? 43 : $website.hashCode());
        final Object $summary = this.getSummary();
        result = result * PRIME + ($summary == null ? 43 : $summary.hashCode());
        final Object $alternativeName = this.getAlternativeName();
        result = result * PRIME + ($alternativeName == null ? 43 : $alternativeName.hashCode());
        final Object $generation = this.getGeneration();
        result = result * PRIME + ($generation == null ? 43 : $generation.hashCode());
        final Object $games = this.getGames();
        result = result * PRIME + ($games == null ? 43 : $games.hashCode());
        final Object $versions = this.getVersions();
        result = result * PRIME + ($versions == null ? 43 : $versions.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Platform;
    }

    public String toString() {
        return "com.soutvoid.gamesproject.domain.platform.Platform(id=" + this.getId() + ", name=" + this.getName() + ", slug=" + this.getSlug() + ", url=" + this.getUrl() + ", createdAt=" + this.getCreatedAt() + ", updatedAt=" + this.getUpdatedAt() + ", logo=" + this.getLogo() + ", website=" + this.getWebsite() + ", summary=" + this.getSummary() + ", alternativeName=" + this.getAlternativeName() + ", generation=" + this.getGeneration() + ", games=" + this.getGames() + ", versions=" + this.getVersions() + ")";
    }
}
