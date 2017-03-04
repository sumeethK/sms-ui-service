package com.sumeeth.webapp.exception;

import org.springframework.stereotype.Component;

/**
 * Created by daljit on 03-Dec-16.
 */
@Component
public class ErrorImpl implements Error {
    private String errCode;
    private String errDesc;



    @Override
    public String getErrorCode() {
        return errCode;
    }

    @Override
    public void setErrorCode(String errorCode) {
        this.errCode = errorCode;
    }

    @Override
    public String getErrorDesc() {
        return errDesc;
    }

    @Override
    public void setErrorDesc(String errorDesc) {
        this.errDesc = errorDesc;
    }

    @Override
    public String toString() {
        return "errorObj{" +
                "errCode='" + errCode + '\'' +
                ", errDesc='" + errDesc + '\'' +
                '}';
    }
}
