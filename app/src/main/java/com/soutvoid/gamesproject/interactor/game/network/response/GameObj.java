package com.soutvoid.gamesproject.interactor.game.network.response;

import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.game.Game;
import com.soutvoid.gamesproject.interactor.common.network.TransformUtil;
import com.soutvoid.gamesproject.util.Transformable;

import java.util.ArrayList;

import lombok.Data;

@Data
public class GameObj implements Transformable<Game> {

    @SerializedName("id")
    public Integer id;
    @SerializedName("name")
    public String name;
    @SerializedName("slug")
    public String slug;
    @SerializedName("url")
    public String url;
    @SerializedName("created_at")
    public Long createdAt;
    @SerializedName("updated_at")
    public Long updatedAt;
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
    public ArrayList<Integer> developers = null;
    @SerializedName("publishers")
    public ArrayList<Integer> publishers = null;
    @SerializedName("category")
    public Integer category;
    @SerializedName("player_perspectives")
    public ArrayList<Integer> playerPerspectives = null;
    @SerializedName("game_modes")
    public ArrayList<Integer> gameModes = null;
    @SerializedName("keywords")
    public ArrayList<Integer> keywords = null;
    @SerializedName("themes")
    public ArrayList<Integer> themes = null;
    @SerializedName("genres")
    public ArrayList<Integer> genres = null;
    @SerializedName("first_release_date")
    public Long firstReleaseDate;
    @SerializedName("release_dates")
    public ArrayList<ReleaseDateObj> releaseDateObjs = null;
    @SerializedName("alternative_names")
    public ArrayList<AlternativeNameObj> alternativeNameObjs = null;
    @SerializedName("screenshots")
    public ArrayList<ScreenshotObj> screenshotObjs = null;
    @SerializedName("videos")
    public ArrayList<VideoObj> videoObjs = null;
    @SerializedName("cover")
    public CoverObj coverObj;
    @SerializedName("esrb")
    public EsrbObj esrbObj;
    @SerializedName("pegi")
    public PegiObj pegiObj;

    @Override
    public Game transform() {
        return new Game(
                id,
                name,
                slug,
                url,
                createdAt,
                updatedAt,
                summary,
                storyline,
                collection,
                hypes,
                popularity,
                developers,
                publishers,
                category,
                playerPerspectives,
                gameModes,
                keywords,
                themes,
                genres,
                firstReleaseDate,
                TransformUtil.transformCollection(releaseDateObjs),
                TransformUtil.transformCollection(alternativeNameObjs),
                TransformUtil.transformCollection(screenshotObjs),
                TransformUtil.transformCollection(videoObjs),
                TransformUtil.transform(coverObj),
                TransformUtil.transform(esrbObj),
                TransformUtil.transform(pegiObj)
        );
    }
}
