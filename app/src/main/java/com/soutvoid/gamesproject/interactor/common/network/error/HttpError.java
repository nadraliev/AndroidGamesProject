package com.soutvoid.gamesproject.interactor.common.network.error;

import com.soutvoid.gamesproject.interactor.common.network.response.BaseResponse;

/**
 * Created by andrew on 2/21/17.
 */

public class HttpError extends NetworkException {

    private int code;
    private BaseResponse errorResponse;

    public HttpError(String message, Throwable cause, int code, BaseResponse errorResponse) {
        super(message, cause);
        this.code = code;
        this.errorResponse = errorResponse;
    }

    public int getCode() {
        return code;
    }

    public BaseResponse getErrorResponse() {
        return errorResponse;
    }
}
