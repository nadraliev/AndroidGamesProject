package com.soutvoid.gamesproject.interactor.util

import io.realm.RealmList
import io.realm.RealmObject

object RealmWrapUtils {

    fun <T : RealmObject> convertList(original: List<T>): RealmList<T> {
        val result = RealmList<T>()
        result.addAll(original)
        return result
    }

    fun wrapString(string: String): RealmString {
        return RealmString(string)
    }

    fun wrapLong(`val`: Long): RealmLong {
        return RealmLong(`val`)
    }

    fun wrapStrings(strings: List<String>): RealmList<RealmString> {
        return RealmWrapUtils.convertList(
                strings.mapIndexed { _, s -> wrapString(s) }.toList())
    }

    fun wrapLongs(Longs: List<Long>): RealmList<RealmLong> {
        return RealmWrapUtils.convertList(
                Longs.map { wrapLong(it) }.toList())
    }

}
