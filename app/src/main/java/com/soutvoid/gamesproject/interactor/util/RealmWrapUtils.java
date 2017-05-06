package com.soutvoid.gamesproject.interactor.util;

import java.util.Arrays;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class RealmWrapUtils {

    public static <T extends RealmObject> RealmList<T> convertList(List<T> original) {
        RealmList<T> result = new RealmList<>();
        result.addAll(original);
        return result;
    }

    public static RealmString wrapString(String string) {
        return new RealmString(string);
    }

    public static RealmList<RealmString> wrapStrings(List<String> strings) {
        return RealmWrapUtils.convertList(
                Arrays.asList(strings
                        .stream()
                        .map(RealmWrapUtils::wrapString)
                        .toArray(RealmString[]::new)));
    }

}
