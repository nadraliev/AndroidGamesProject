package com.soutvoid.gamesproject.interactor.util

import android.text.Html
import com.google.gson.GsonBuilder
import com.soutvoid.gamesproject.interactor.common.FilterRequestFormatList
import com.soutvoid.gamesproject.interactor.common.network.AnnotationExclusionStrategy
import com.soutvoid.gamesproject.interactor.common.network.parse.FilterAdapter
import com.soutvoid.gamesproject.util.Mapper
import com.soutvoid.gamesproject.util.SdkUtil
import com.soutvoid.gamesproject.util.Transformable
import java.util.*

/**
 * Created by andrew on 2/21/17.
 */

object TransformUtil {

    val gson = GsonBuilder()
            .registerTypeAdapter(FilterRequestFormatList::class.java, FilterAdapter())
            .setExclusionStrategies(AnnotationExclusionStrategy())
            .create()

    fun <T, E : Transformable<T>> transform(`object`: E?): T? {
        return `object`?.transform()
    }

    fun <T, E : Transformable<T>> transformCollection(src: Collection<E>): ArrayList<T> {
        return CollectionUtils.mapEmptyIfNull<E, T>(src, Mapper<E, T> { it.transform() })
    }

    /**
     * Заменяет форматирующие символы Html на нормальные (например &quot; -> ")
     */
    fun sanitizeHtmlString(string: String?): String? {
        if (string == null) {
            return null
        }
        if (SdkUtil.supportsVersionCode(android.os.Build.VERSION_CODES.N)) {
            return Html.fromHtml(string, 0).toString()
        } else {
            return Html.fromHtml(string).toString()
        }
    }

}
