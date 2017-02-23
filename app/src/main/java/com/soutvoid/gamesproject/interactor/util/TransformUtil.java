package com.soutvoid.gamesproject.interactor.util;

import android.support.annotation.Nullable;
import android.text.Html;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.soutvoid.gamesproject.interactor.common.FilterRequestFormatList;
import com.soutvoid.gamesproject.interactor.common.network.AnnotationExclusionStrategy;
import com.soutvoid.gamesproject.interactor.common.network.parse.FilterAdapter;
import com.soutvoid.gamesproject.util.SdkUtil;
import com.soutvoid.gamesproject.util.Transformable;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by andrew on 2/21/17.
 */

public class TransformUtil {

    public static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(FilterRequestFormatList.class, new FilterAdapter())
            .setExclusionStrategies(new AnnotationExclusionStrategy())
            .create();

    public static <T, E extends Transformable<T>> T transform(@Nullable E object) {
        return object != null ? object.transform() : null;
    }

    public static <T, E extends Transformable<T>> ArrayList<T> transformCollection(Collection<E> src) {
        return CollectionUtils.mapEmptyIfNull(src, Transformable::transform);
    }

    /**
     * Заменяет форматирующие символы Html на нормальные (например &quot; -> ")
     */
    public static String sanitizeHtmlString(String string) {
        if (string == null) {
            return null;
        }
        if (SdkUtil.supportsVersionCode(android.os.Build.VERSION_CODES.N)) {
            return Html.fromHtml(string, 0).toString();
        } else {
            return Html.fromHtml(string).toString();
        }
    }

}
