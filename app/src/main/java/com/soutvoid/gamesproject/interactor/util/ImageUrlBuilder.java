package com.soutvoid.gamesproject.interactor.util;


import android.net.Uri;

import java.util.List;

import static com.soutvoid.gamesproject.interactor.common.network.ServerUrls.IMAGE_BASE_URL;

public class ImageUrlBuilder {

    private final String SIZE_PREFIX = "t_";

    public enum ImageSize {
        cover_small,
        screenshot_med,
        cover_big,
        logo_med,
        screenshot_big,
        screenshot_huge,
        thumb,
        micro
    }

    private String sizeString;
    private String hash;

    public ImageUrlBuilder() {
    }

    public ImageUrlBuilder(String originalUrl) {
        parse(originalUrl);
    }

    public ImageUrlBuilder parse(String originalUrl) {
        Uri uri = Uri.parse(originalUrl);
        List<String> pathSegments = uri.getPathSegments();
        hash = pathSegments.get(pathSegments.size() - 1);
        sizeString = pathSegments.get(pathSegments.size() - 2);
        return this;
    }

    public ImageUrlBuilder setSize(ImageSize size) {
        sizeString = SIZE_PREFIX + size.toString();
        return this;
    }

    public String build() {
        return Uri.parse(IMAGE_BASE_URL).buildUpon()
                .appendPath(sizeString)
                .appendPath(hash)
                .build().toString();
    }

    public ImageUrlBuilder clear() {
        sizeString = "";
        hash = "";
        return this;
    }
}
