package com.hastings.tpc.consentmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

   // private static final long serialVersionUID = 1L;

    private String errorCode;
    private String message;
    private String details;

    public ResourceNotFoundException(String errorCode, String message, String details){
        super(message);
        this.details = details;
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
