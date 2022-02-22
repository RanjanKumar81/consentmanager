package com.hastings.tpc.consentmanager.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
    private String message;
    private String details;
    private String errorCode;

    public ErrorDetails(String errorCode, String message, String details) {
        super();
        this.message = message;
        this.details = details;
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}