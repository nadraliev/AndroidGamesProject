package com.soutvoid.gamesproject.interactor.game.network.response;

import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.game.Video;
import com.soutvoid.gamesproject.util.Transformable;

/**
 * Created by andrew on 2/21/17.
 */

public class VideoObj implements Transformable<Video> {

    @SerializedName("name")
    public String name;
    @SerializedName("video_id")
    public String videoId;

    @Override
    public Video transform() {
        return new Video(
                name,
                videoId
        );
    }
}
