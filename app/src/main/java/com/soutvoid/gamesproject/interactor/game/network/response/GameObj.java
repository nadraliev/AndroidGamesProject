package com.soutvoid.gamesproject.interactor.game.network.response;

import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.game.Game;
import com.soutvoid.gamesproject.domain.game.TimeToBeat;
import com.soutvoid.gamesproject.interactor.common.network.response.ImageObj;
import com.soutvoid.gamesproject.interactor.util.TransformUtil;
import com.soutvoid.gamesproject.util.Transformable;

import java.util.ArrayList;

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
    @SerializedName("game_engines")
    private ArrayList<Long> gameEngines;
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
    private ArrayList<ImageObj> screenshotsObjs = null;
    @SerializedName("videos")
    private ArrayList<VideoObj> videoObjs = null;
    @SerializedName("cover")
    private ImageObj coverObj;
    @SerializedName("esrb")
    private EsrbObj esrbObj;
    @SerializedName("pegi")
    private PegiObj pegiObj;

    public GameObj() {
    }

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
                gameEngines,
                category,
                timeToBeat,
                playerPerspectives,
                gameModes,
                keywords,
                themes,
                genres,
                firstReleaseDate,
                status,
                TransformUtil.INSTANCE.transformCollection(releaseDateObjs),
                TransformUtil.INSTANCE.transformCollection(alternativeNameObjs),
                TransformUtil.INSTANCE.transformCollection(screenshotsObjs),
                TransformUtil.INSTANCE.transformCollection(videoObjs),
                TransformUtil.INSTANCE.transform(coverObj),
                TransformUtil.INSTANCE.transform(esrbObj),
                TransformUtil.INSTANCE.transform(pegiObj)
        );
    }

    public Integer getId() {
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

    public String getSummary() {
        return this.summary;
    }

    public String getStoryline() {
        return this.storyline;
    }

    public Integer getCollection() {
        return this.collection;
    }

    public Long getFranchise() {
        return this.franchise;
    }

    public Integer getHypes() {
        return this.hypes;
    }

    public Double getPopularity() {
        return this.popularity;
    }

    public Double getAggregatedRating() {
        return this.aggregatedRating;
    }

    public Long getGame() {
        return this.game;
    }

    public Double getRating() {
        return this.rating;
    }

    public Integer getRatingCount() {
        return this.ratingCount;
    }

    public ArrayList<Integer> getDevelopers() {
        return this.developers;
    }

    public ArrayList<Integer> getPublishers() {
        return this.publishers;
    }

    public ArrayList<Long> getGameEngines() {
        return this.gameEngines;
    }

    public Integer getCategory() {
        return this.category;
    }

    public TimeToBeat getTimeToBeat() {
        return this.timeToBeat;
    }

    public ArrayList<Integer> getPlayerPerspectives() {
        return this.playerPerspectives;
    }

    public ArrayList<Integer> getGameModes() {
        return this.gameModes;
    }

    public ArrayList<Integer> getKeywords() {
        return this.keywords;
    }

    public ArrayList<Integer> getThemes() {
        return this.themes;
    }

    public ArrayList<Integer> getGenres() {
        return this.genres;
    }

    public Long getFirstReleaseDate() {
        return this.firstReleaseDate;
    }

    public Integer getStatus() {
        return this.status;
    }

    public ArrayList<ReleaseDateObj> getReleaseDateObjs() {
        return this.releaseDateObjs;
    }

    public ArrayList<AlternativeNameObj> getAlternativeNameObjs() {
        return this.alternativeNameObjs;
    }

    public ArrayList<ImageObj> getScreenshotsObjs() {
        return this.screenshotsObjs;
    }

    public ArrayList<VideoObj> getVideoObjs() {
        return this.videoObjs;
    }

    public ImageObj getCoverObj() {
        return this.coverObj;
    }

    public EsrbObj getEsrbObj() {
        return this.esrbObj;
    }

    public PegiObj getPegiObj() {
        return this.pegiObj;
    }

    public void setId(Integer id) {
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

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setStoryline(String storyline) {
        this.storyline = storyline;
    }

    public void setCollection(Integer collection) {
        this.collection = collection;
    }

    public void setFranchise(Long franchise) {
        this.franchise = franchise;
    }

    public void setHypes(Integer hypes) {
        this.hypes = hypes;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public void setAggregatedRating(Double aggregatedRating) {
        this.aggregatedRating = aggregatedRating;
    }

    public void setGame(Long game) {
        this.game = game;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public void setDevelopers(ArrayList<Integer> developers) {
        this.developers = developers;
    }

    public void setPublishers(ArrayList<Integer> publishers) {
        this.publishers = publishers;
    }

    public void setGameEngines(ArrayList<Long> gameEngines) {
        this.gameEngines = gameEngines;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public void setTimeToBeat(TimeToBeat timeToBeat) {
        this.timeToBeat = timeToBeat;
    }

    public void setPlayerPerspectives(ArrayList<Integer> playerPerspectives) {
        this.playerPerspectives = playerPerspectives;
    }

    public void setGameModes(ArrayList<Integer> gameModes) {
        this.gameModes = gameModes;
    }

    public void setKeywords(ArrayList<Integer> keywords) {
        this.keywords = keywords;
    }

    public void setThemes(ArrayList<Integer> themes) {
        this.themes = themes;
    }

    public void setGenres(ArrayList<Integer> genres) {
        this.genres = genres;
    }

    public void setFirstReleaseDate(Long firstReleaseDate) {
        this.firstReleaseDate = firstReleaseDate;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setReleaseDateObjs(ArrayList<ReleaseDateObj> releaseDateObjs) {
        this.releaseDateObjs = releaseDateObjs;
    }

    public void setAlternativeNameObjs(ArrayList<AlternativeNameObj> alternativeNameObjs) {
        this.alternativeNameObjs = alternativeNameObjs;
    }

    public void setScreenshotsObjs(ArrayList<ImageObj> screenshotsObjs) {
        this.screenshotsObjs = screenshotsObjs;
    }

    public void setVideoObjs(ArrayList<VideoObj> videoObjs) {
        this.videoObjs = videoObjs;
    }

    public void setCoverObj(ImageObj coverObj) {
        this.coverObj = coverObj;
    }

    public void setEsrbObj(EsrbObj esrbObj) {
        this.esrbObj = esrbObj;
    }

    public void setPegiObj(PegiObj pegiObj) {
        this.pegiObj = pegiObj;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof GameObj)) return false;
        final GameObj other = (GameObj) o;
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
        final Object this$summary = this.getSummary();
        final Object other$summary = other.getSummary();
        if (this$summary == null ? other$summary != null : !this$summary.equals(other$summary))
            return false;
        final Object this$storyline = this.getStoryline();
        final Object other$storyline = other.getStoryline();
        if (this$storyline == null ? other$storyline != null : !this$storyline.equals(other$storyline))
            return false;
        final Object this$collection = this.getCollection();
        final Object other$collection = other.getCollection();
        if (this$collection == null ? other$collection != null : !this$collection.equals(other$collection))
            return false;
        final Object this$franchise = this.getFranchise();
        final Object other$franchise = other.getFranchise();
        if (this$franchise == null ? other$franchise != null : !this$franchise.equals(other$franchise))
            return false;
        final Object this$hypes = this.getHypes();
        final Object other$hypes = other.getHypes();
        if (this$hypes == null ? other$hypes != null : !this$hypes.equals(other$hypes))
            return false;
        final Object this$popularity = this.getPopularity();
        final Object other$popularity = other.getPopularity();
        if (this$popularity == null ? other$popularity != null : !this$popularity.equals(other$popularity))
            return false;
        final Object this$aggregatedRating = this.getAggregatedRating();
        final Object other$aggregatedRating = other.getAggregatedRating();
        if (this$aggregatedRating == null ? other$aggregatedRating != null : !this$aggregatedRating.equals(other$aggregatedRating))
            return false;
        final Object this$game = this.getGame();
        final Object other$game = other.getGame();
        if (this$game == null ? other$game != null : !this$game.equals(other$game)) return false;
        final Object this$rating = this.getRating();
        final Object other$rating = other.getRating();
        if (this$rating == null ? other$rating != null : !this$rating.equals(other$rating))
            return false;
        final Object this$ratingCount = this.getRatingCount();
        final Object other$ratingCount = other.getRatingCount();
        if (this$ratingCount == null ? other$ratingCount != null : !this$ratingCount.equals(other$ratingCount))
            return false;
        final Object this$developers = this.getDevelopers();
        final Object other$developers = other.getDevelopers();
        if (this$developers == null ? other$developers != null : !this$developers.equals(other$developers))
            return false;
        final Object this$publishers = this.getPublishers();
        final Object other$publishers = other.getPublishers();
        if (this$publishers == null ? other$publishers != null : !this$publishers.equals(other$publishers))
            return false;
        final Object this$gameEngines = this.getGameEngines();
        final Object other$gameEngines = other.getGameEngines();
        if (this$gameEngines == null ? other$gameEngines != null : !this$gameEngines.equals(other$gameEngines))
            return false;
        final Object this$category = this.getCategory();
        final Object other$category = other.getCategory();
        if (this$category == null ? other$category != null : !this$category.equals(other$category))
            return false;
        final Object this$timeToBeat = this.getTimeToBeat();
        final Object other$timeToBeat = other.getTimeToBeat();
        if (this$timeToBeat == null ? other$timeToBeat != null : !this$timeToBeat.equals(other$timeToBeat))
            return false;
        final Object this$playerPerspectives = this.getPlayerPerspectives();
        final Object other$playerPerspectives = other.getPlayerPerspectives();
        if (this$playerPerspectives == null ? other$playerPerspectives != null : !this$playerPerspectives.equals(other$playerPerspectives))
            return false;
        final Object this$gameModes = this.getGameModes();
        final Object other$gameModes = other.getGameModes();
        if (this$gameModes == null ? other$gameModes != null : !this$gameModes.equals(other$gameModes))
            return false;
        final Object this$keywords = this.getKeywords();
        final Object other$keywords = other.getKeywords();
        if (this$keywords == null ? other$keywords != null : !this$keywords.equals(other$keywords))
            return false;
        final Object this$themes = this.getThemes();
        final Object other$themes = other.getThemes();
        if (this$themes == null ? other$themes != null : !this$themes.equals(other$themes))
            return false;
        final Object this$genres = this.getGenres();
        final Object other$genres = other.getGenres();
        if (this$genres == null ? other$genres != null : !this$genres.equals(other$genres))
            return false;
        final Object this$firstReleaseDate = this.getFirstReleaseDate();
        final Object other$firstReleaseDate = other.getFirstReleaseDate();
        if (this$firstReleaseDate == null ? other$firstReleaseDate != null : !this$firstReleaseDate.equals(other$firstReleaseDate))
            return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status))
            return false;
        final Object this$releaseDateObjs = this.getReleaseDateObjs();
        final Object other$releaseDateObjs = other.getReleaseDateObjs();
        if (this$releaseDateObjs == null ? other$releaseDateObjs != null : !this$releaseDateObjs.equals(other$releaseDateObjs))
            return false;
        final Object this$alternativeNameObjs = this.getAlternativeNameObjs();
        final Object other$alternativeNameObjs = other.getAlternativeNameObjs();
        if (this$alternativeNameObjs == null ? other$alternativeNameObjs != null : !this$alternativeNameObjs.equals(other$alternativeNameObjs))
            return false;
        final Object this$screenshotsObjs = this.getScreenshotsObjs();
        final Object other$screenshotsObjs = other.getScreenshotsObjs();
        if (this$screenshotsObjs == null ? other$screenshotsObjs != null : !this$screenshotsObjs.equals(other$screenshotsObjs))
            return false;
        final Object this$videoObjs = this.getVideoObjs();
        final Object other$videoObjs = other.getVideoObjs();
        if (this$videoObjs == null ? other$videoObjs != null : !this$videoObjs.equals(other$videoObjs))
            return false;
        final Object this$coverObj = this.getCoverObj();
        final Object other$coverObj = other.getCoverObj();
        if (this$coverObj == null ? other$coverObj != null : !this$coverObj.equals(other$coverObj))
            return false;
        final Object this$esrbObj = this.getEsrbObj();
        final Object other$esrbObj = other.getEsrbObj();
        if (this$esrbObj == null ? other$esrbObj != null : !this$esrbObj.equals(other$esrbObj))
            return false;
        final Object this$pegiObj = this.getPegiObj();
        final Object other$pegiObj = other.getPegiObj();
        if (this$pegiObj == null ? other$pegiObj != null : !this$pegiObj.equals(other$pegiObj))
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
        final Object $summary = this.getSummary();
        result = result * PRIME + ($summary == null ? 43 : $summary.hashCode());
        final Object $storyline = this.getStoryline();
        result = result * PRIME + ($storyline == null ? 43 : $storyline.hashCode());
        final Object $collection = this.getCollection();
        result = result * PRIME + ($collection == null ? 43 : $collection.hashCode());
        final Object $franchise = this.getFranchise();
        result = result * PRIME + ($franchise == null ? 43 : $franchise.hashCode());
        final Object $hypes = this.getHypes();
        result = result * PRIME + ($hypes == null ? 43 : $hypes.hashCode());
        final Object $popularity = this.getPopularity();
        result = result * PRIME + ($popularity == null ? 43 : $popularity.hashCode());
        final Object $aggregatedRating = this.getAggregatedRating();
        result = result * PRIME + ($aggregatedRating == null ? 43 : $aggregatedRating.hashCode());
        final Object $game = this.getGame();
        result = result * PRIME + ($game == null ? 43 : $game.hashCode());
        final Object $rating = this.getRating();
        result = result * PRIME + ($rating == null ? 43 : $rating.hashCode());
        final Object $ratingCount = this.getRatingCount();
        result = result * PRIME + ($ratingCount == null ? 43 : $ratingCount.hashCode());
        final Object $developers = this.getDevelopers();
        result = result * PRIME + ($developers == null ? 43 : $developers.hashCode());
        final Object $publishers = this.getPublishers();
        result = result * PRIME + ($publishers == null ? 43 : $publishers.hashCode());
        final Object $gameEngines = this.getGameEngines();
        result = result * PRIME + ($gameEngines == null ? 43 : $gameEngines.hashCode());
        final Object $category = this.getCategory();
        result = result * PRIME + ($category == null ? 43 : $category.hashCode());
        final Object $timeToBeat = this.getTimeToBeat();
        result = result * PRIME + ($timeToBeat == null ? 43 : $timeToBeat.hashCode());
        final Object $playerPerspectives = this.getPlayerPerspectives();
        result = result * PRIME + ($playerPerspectives == null ? 43 : $playerPerspectives.hashCode());
        final Object $gameModes = this.getGameModes();
        result = result * PRIME + ($gameModes == null ? 43 : $gameModes.hashCode());
        final Object $keywords = this.getKeywords();
        result = result * PRIME + ($keywords == null ? 43 : $keywords.hashCode());
        final Object $themes = this.getThemes();
        result = result * PRIME + ($themes == null ? 43 : $themes.hashCode());
        final Object $genres = this.getGenres();
        result = result * PRIME + ($genres == null ? 43 : $genres.hashCode());
        final Object $firstReleaseDate = this.getFirstReleaseDate();
        result = result * PRIME + ($firstReleaseDate == null ? 43 : $firstReleaseDate.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $releaseDateObjs = this.getReleaseDateObjs();
        result = result * PRIME + ($releaseDateObjs == null ? 43 : $releaseDateObjs.hashCode());
        final Object $alternativeNameObjs = this.getAlternativeNameObjs();
        result = result * PRIME + ($alternativeNameObjs == null ? 43 : $alternativeNameObjs.hashCode());
        final Object $screenshotsObjs = this.getScreenshotsObjs();
        result = result * PRIME + ($screenshotsObjs == null ? 43 : $screenshotsObjs.hashCode());
        final Object $videoObjs = this.getVideoObjs();
        result = result * PRIME + ($videoObjs == null ? 43 : $videoObjs.hashCode());
        final Object $coverObj = this.getCoverObj();
        result = result * PRIME + ($coverObj == null ? 43 : $coverObj.hashCode());
        final Object $esrbObj = this.getEsrbObj();
        result = result * PRIME + ($esrbObj == null ? 43 : $esrbObj.hashCode());
        final Object $pegiObj = this.getPegiObj();
        result = result * PRIME + ($pegiObj == null ? 43 : $pegiObj.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof GameObj;
    }

    public String toString() {
        return "com.soutvoid.gamesproject.interactor.game.network.response.GameObj(id=" + this.getId() + ", name=" + this.getName() + ", slug=" + this.getSlug() + ", url=" + this.getUrl() + ", createdAt=" + this.getCreatedAt() + ", updatedAt=" + this.getUpdatedAt() + ", summary=" + this.getSummary() + ", storyline=" + this.getStoryline() + ", collection=" + this.getCollection() + ", franchise=" + this.getFranchise() + ", hypes=" + this.getHypes() + ", popularity=" + this.getPopularity() + ", aggregatedRating=" + this.getAggregatedRating() + ", game=" + this.getGame() + ", rating=" + this.getRating() + ", ratingCount=" + this.getRatingCount() + ", developers=" + this.getDevelopers() + ", publishers=" + this.getPublishers() + ", gameEngines=" + this.getGameEngines() + ", category=" + this.getCategory() + ", timeToBeat=" + this.getTimeToBeat() + ", playerPerspectives=" + this.getPlayerPerspectives() + ", gameModes=" + this.getGameModes() + ", keywords=" + this.getKeywords() + ", themes=" + this.getThemes() + ", genres=" + this.getGenres() + ", firstReleaseDate=" + this.getFirstReleaseDate() + ", status=" + this.getStatus() + ", releaseDateObjs=" + this.getReleaseDateObjs() + ", alternativeNameObjs=" + this.getAlternativeNameObjs() + ", screenshotsObjs=" + this.getScreenshotsObjs() + ", videoObjs=" + this.getVideoObjs() + ", coverObj=" + this.getCoverObj() + ", esrbObj=" + this.getEsrbObj() + ", pegiObj=" + this.getPegiObj() + ")";
    }
}
