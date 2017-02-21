package com.soutvoid.gamesproject.interactor.game.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class GameObj {

    @SerializedName("id")
    public Integer id;
    @SerializedName("name")
    public String name;
    @SerializedName("slug")
    public String slug;
    @SerializedName("url")
    public String url;
    @SerializedName("created_at")
    public Integer createdAt;
    @SerializedName("updated_at")
    public Integer updatedAt;
    @SerializedName("summary")
    public String summary;
    @SerializedName("storyline")
    public String storyline;
    @SerializedName("collection")
    public Integer collection;
    @SerializedName("hypes")
    public Integer hypes;
    @SerializedName("popularity")
    public Double popularity;
    @SerializedName("developers")
    public List<Integer> developers = null;
    @SerializedName("publishers")
    public List<Integer> publishers = null;
    @SerializedName("category")
    public Integer category;
    @SerializedName("player_perspectives")
    public List<Integer> playerPerspectives = null;
    @SerializedName("game_modes")
    public List<Integer> gameModes = null;
    @SerializedName("keywords")
    public List<Integer> keywords = null;
    @SerializedName("themes")
    public List<Integer> themes = null;
    @SerializedName("genres")
    public List<Integer> genres = null;
    @SerializedName("first_release_date")
    public Integer firstReleaseDate;
    @SerializedName("release_dates")
    public List<ReleaseDateObj> releaseDateObjs = null;
    @SerializedName("alternative_names")
    public List<AlternativeNameObj> alternativeNameObjs = null;
    @SerializedName("screenshots")
    public List<ScreenshotObj> screenshotObjs = null;
    @SerializedName("videos")
    public List<VideoObj> videoObjs = null;
    @SerializedName("cover")
    public CoverObj coverObj;
    @SerializedName("esrb")
    public EsrbObj esrbObj;
    @SerializedName("pegi")
    public PegiObj pegiObj;

}
