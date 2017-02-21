package com.soutvoid.gamesproject.util;

import android.os.Build;

/**
 * Утилита для проверки поддержки нужного уровня API
 */
public class SdkUtil {

    public static boolean supportsN() {
        return supportsVersionCode(Build.VERSION_CODES.N);
    }

    public static boolean supportsM() {
        return supportsVersionCode(Build.VERSION_CODES.M);
    }

    public static boolean supportsLollipop() {
        return supportsVersionCode(Build.VERSION_CODES.LOLLIPOP);
    }

    public static boolean supportsKitkat() {
        return supportsVersionCode(Build.VERSION_CODES.KITKAT);
    }

    public static boolean supportsJellybean() {
        return supportsVersionCode(Build.VERSION_CODES.JELLY_BEAN);
    }

    public static boolean supportsVersionCode(int versionCode) {
        return Build.VERSION.SDK_INT >= versionCode;
    }
}