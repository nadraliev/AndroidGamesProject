package com.soutvoid.gamesproject.app.log;

import android.util.Log;

import timber.log.Timber;

/**
 * Created by andrew on 2/20/17.
 */

/**
 * логгирует в logcat
 * логи уровня DEBUG и выше логируется в {@link RemoteLogger}
 */
public class LoggerTree extends Timber.DebugTree {

    public static final String REMOTE_LOGGER_LOG_FORMAT = "%s: %s";
    public static final String REMOTE_LOGGER_SEND_LOG_ERROR = "error sending to RemoteLogger";
    private final int mLogPriority;


    /**
     * приоритет по умолчанию - DEBUG
     */
    public LoggerTree() {
        this(Log.DEBUG);
    }

    public LoggerTree(int mLogPriority) {
        this.mLogPriority = mLogPriority;
    }

    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
        super.log(priority, tag, message, t);
        try {
            if (priority >= mLogPriority) {
                RemoteLogger.logMessage(String.format(REMOTE_LOGGER_LOG_FORMAT, tag, message));
                if (t != null && priority >= Log.ERROR) {
                    RemoteLogger.logError(t);
                }
            }
        } catch (Exception e) {
            super.log(priority, tag, "Remote logger error", t);
        }
    }
}
