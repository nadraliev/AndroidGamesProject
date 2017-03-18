package com.soutvoid.gamesproject.ui.common.error;

import com.soutvoid.gamesproject.app.log.Logger;
import com.soutvoid.gamesproject.interactor.common.network.error.ConversionException;
import com.soutvoid.gamesproject.interactor.common.network.error.HttpError;
import com.soutvoid.gamesproject.interactor.common.network.error.NetworkException;
import com.soutvoid.gamesproject.interactor.common.network.error.NoInternetException;

import java.util.List;

import rx.exceptions.CompositeException;

/**
 * Created by andrew on 3/18/17.
 */

public abstract class ErrorHandler {

    public void handleError(Throwable t) {
        Logger.i(t, "ErrorHandler handle error");
        if (t instanceof CompositeException) {
            handleCompositeException((CompositeException) t);
        } else if (t instanceof HttpError) {
            handleHttpError((HttpError) t);
        } else if (t instanceof NoInternetException) {
            handleNoInternetError((NoInternetException) t);
        } else if (t instanceof ConversionException) {
            handleConversionError((ConversionException) t);
        } else {
            handleOtherError(t);
        }
    }

    /**
     * @param err - CompositeException может возникать при комбинировании Observable
     */
    private void handleCompositeException(CompositeException err) {
        List<Throwable> exceptions = err.getExceptions();
        NetworkException networkException = null;
        Throwable otherException = null;
        for (Throwable e : exceptions) {
            if (e instanceof NetworkException) {
                if (networkException == null) {
                    networkException = (NetworkException) e;
                }
            } else if (otherException == null) {
                otherException = e;
            }
        }
        if (networkException != null) {
            handleError(networkException);
        }
        if (otherException != null) {
            handleOtherError(otherException);
        }
    }


    protected abstract void handleHttpError(HttpError e);

    protected abstract void handleNoInternetError(NoInternetException e);

    protected abstract void handleConversionError(ConversionException e);

    protected abstract void handleOtherError(Throwable e);
}
