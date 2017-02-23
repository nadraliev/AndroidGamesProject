package com.soutvoid.gamesproject.interactor.game.network.response;

import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.game.Game;
import com.soutvoid.gamesproject.domain.game.TimeToBeat;
import com.soutvoid.gamesproject.interactor.common.network.TransformUtil;
import com.soutvoid.gamesproject.util.Transformable;

import java.util.ArrayList;

import lombok.Data;

@Data
public class GameObj implements Transformable<Game> {

    @SerializedName("id")
    private Integer id;
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
    @SerializedName("summary")
    private String summary;
    @SerializedName("storyline")
    private String storyline;
    @SerializedName("collection")
    private Integer collection;
    @SerializedName("franchise")
    private Long franchise;
    @SerializedName("hypes")
    private Integer hypes;
    @SerializedName("popularity")
    private Double popularity;
    @SerializedName("aggregated_rating")
    private Double aggregatedRating;
    @SerializedName("game")
    private Long game;
    @SerializedName("rating")
    private Double rating;
    @SerializedName("rating_count")
    private Integer ratingCount;
    @SerializedName("developers")
    private ArrayList<Integer> developers = null;
    @SerializedName("publishers")
    private ArrayList<Integer> publishers = null;
    @SerializedName("category")
    private Integer category;
    @SerializedName("time_to_beat")
    private TimeToBeat timeToBeat;
    @SerializedName("player_perspectives")
    private ArrayList<Integer> playerPerspectives = null;
    @SerializedName("game_modes")
    private ArrayList<Integer> gameModes = null;
    @SerializedName("keywords")
    private ArrayList<Integer> keywords = null;
    @SerializedName("themes")
    private ArrayList<Integer> themes = null;
    @SerializedName("genres")
    private ArrayList<Integer> genres = null;
    @SerializedName("first_release_date")
    private Long firstReleaseDate;
    @SerializedName("status")
    private Integer status;
    @SerializedName("release_dates")
    private ArrayList<ReleaseDateObj> releaseDateObjs = null;
    @SerializedName("alternative_names")
    private ArrayList<AlternativeNameObj> alternativeNameObjs = null;
    @SerializedName("screenshots")
    private ArrayList<ScreenshotObj> screenshotObjs = null;
    @SerializedName("videos")
    private ArrayList<VideoObj> videoObjs = null;
    @SerializedName("cover")
    private CoverObj coverObj;
    @SerializedName("esrb")
    private EsrbObj esrbObj;
    @SerializedName("pegi")
    private PegiObj pegiObj;

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
                franchise,
                rating,
                ratingCount,
                hypes,
                popularity,
                aggregatedRating,
                game,
                developers,
                publishers,
                category,
                timeToBeat,
                playerPerspectives,
                gameModes,
                keywords,
                themes,
                genres,
                firstReleaseDate,
                status,
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
