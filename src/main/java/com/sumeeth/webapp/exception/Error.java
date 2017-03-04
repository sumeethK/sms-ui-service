package com.sumeeth.webapp.exception;

/**
 * Created by daljit on 03-Dec-16.
 */
public interface Error {

    String getErrorCode();
    String getErrorDesc();

    void setErrorCode(String errorCode);
    void setErrorDesc(String errorDesc);
}
