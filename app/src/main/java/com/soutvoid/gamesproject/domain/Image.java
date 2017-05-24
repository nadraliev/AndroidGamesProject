
package com.soutvoid.gamesproject.domain;

import java.io.Serializable;
import java.lang.reflect.Field;

public class Image implements Serializable {

    public String url;
    public String cloudinaryId;
    public Integer width;
    public Integer height;


    public Image(String url, String cloudinaryId, Integer width, Integer height) {
        this.url = url;
        this.cloudinaryId = cloudinaryId;
        this.width = width;
        this.height = height;
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

    public String getUrl() {
        return this.url;
    }

    public String getCloudinaryId() {
        return this.cloudinaryId;
    }

    public Integer getWidth() {
        return this.width;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCloudinaryId(String cloudinaryId) {
        this.cloudinaryId = cloudinaryId;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Image)) return false;
        final Image other = (Image) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$url = this.getUrl();
        final Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) return false;
        final Object this$cloudinaryId = this.getCloudinaryId();
        final Object other$cloudinaryId = other.getCloudinaryId();
        if (this$cloudinaryId == null ? other$cloudinaryId != null : !this$cloudinaryId.equals(other$cloudinaryId))
            return false;
        final Object this$width = this.getWidth();
        final Object other$width = other.getWidth();
        if (this$width == null ? other$width != null : !this$width.equals(other$width))
            return false;
        final Object this$height = this.getHeight();
        final Object other$height = other.getHeight();
        if (this$height == null ? other$height != null : !this$height.equals(other$height))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $url = this.getUrl();
        result = result * PRIME + ($url == null ? 43 : $url.hashCode());
        final Object $cloudinaryId = this.getCloudinaryId();
        result = result * PRIME + ($cloudinaryId == null ? 43 : $cloudinaryId.hashCode());
        final Object $width = this.getWidth();
        result = result * PRIME + ($width == null ? 43 : $width.hashCode());
        final Object $height = this.getHeight();
        result = result * PRIME + ($height == null ? 43 : $height.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Image;
    }
}
