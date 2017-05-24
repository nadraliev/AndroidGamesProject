
package com.soutvoid.gamesproject.domain.game;

import java.io.Serializable;
import java.lang.reflect.Field;

public class Video implements Serializable {

    public String name;
    public String videoId;


    public Video(String name, String videoId) {
        this.name = name;
        this.videoId = videoId;
    }

    @Override
    public String toString() {
        String result = "";
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field :
                fields) {
            try {
                result += field.getName() + ": " + field.get(this).toString() + "\n";
            } catch (IllegalAccessException | NullPointerException e) {
                //ignore
            }
        }
        return result;
    }

    public String getName() {
        return this.name;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Video)) return false;
        final Video other = (Video) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$videoId = this.getVideoId();
        final Object other$videoId = other.getVideoId();
        if (this$videoId == null ? other$videoId != null : !this$videoId.equals(other$videoId))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $videoId = this.getVideoId();
        result = result * PRIME + ($videoId == null ? 43 : $videoId.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Video;
    }
}
