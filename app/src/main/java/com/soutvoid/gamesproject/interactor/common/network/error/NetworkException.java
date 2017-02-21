package com.soutvoid.gamesproject.interactor.common.network.error;

/**
 * Created by andrew on 2/21/17.
 */

public abstract class NetworkException extends RuntimeException {

    public NetworkException() {
    }

    public NetworkException(String message) {
        super(message);
    }

    public NetworkException(Throwable cause) {
        super(cause);
    }

    public NetworkException(String message, Throwable cause) {
        super(message, cause);
    }
}
