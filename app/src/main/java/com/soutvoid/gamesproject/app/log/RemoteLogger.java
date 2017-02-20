package com.soutvoid.gamesproject.app.log;

import com.crashlytics.android.Crashlytics;

/**
 * Created by andrew on 2/20/17.
 */

public class RemoteLogger {

    public static void setUser(String id, String username, String email) {
        try {
            Crashlytics.getInstance().core.setUserName(username);
            Crashlytics.getInstance().core.setUserEmail(email);
            Crashlytics.getInstance().core.setUserIdentifier(id);
        } catch (Exception e) {
            //ignore exception
        }
    }

    public static void clearUser() {
        try {
            Crashlytics.getInstance().core.setUserName("");
            Crashlytics.getInstance().core.setUserEmail("");
            Crashlytics.getInstance().core.setUserIdentifier("");
        } catch (Exception e) {
            //ignore exception
        }
    }

    public static void setCustomKey(String key, String value) {
        try {
            Crashlytics.getInstance().core.setString(key, value);
        } catch (Exception e) {
            //ignore exception
        }
    }

    public static void logError(Throwable t) {
        try {
            Crashlytics.getInstance().core.logException(t);
        } catch (Exception e) {
            //ignore exception
        }
    }

    public static void logMessage(String message) {
        try {
            Crashlytics.getInstance().core.log(message);
        } catch (Exception e) {
            //ignore exception
        }
    }

}
