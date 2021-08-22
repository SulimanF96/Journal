package com.example.Journal.Exception;

public class ErrorMessage {

    public String errorCode;

    public ErrorMessage(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
