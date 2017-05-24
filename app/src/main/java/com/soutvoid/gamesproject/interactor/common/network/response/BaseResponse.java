package com.soutvoid.gamesproject.interactor.common.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by andrew on 2/21/17.
 */

public class BaseResponse {
    @SerializedName("error")
    private List<String> error;

    public BaseResponse() {
    }

    public List<String> getError() {
        return this.error;
    }

    public void setError(List<String> error) {
        this.error = error;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof BaseResponse)) return false;
        final BaseResponse other = (BaseResponse) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$error = this.getError();
        final Object other$error = other.getError();
        if (this$error == null ? other$error != null : !this$error.equals(other$error))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $error = this.getError();
        result = result * PRIME + ($error == null ? 43 : $error.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof BaseResponse;
    }

    public String toString() {
        return "com.soutvoid.gamesproject.interactor.common.network.response.BaseResponse(error=" + this.getError() + ")";
    }
}
