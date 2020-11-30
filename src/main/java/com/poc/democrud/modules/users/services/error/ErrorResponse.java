package com.poc.democrud.modules.users.services.error;

import org.springframework.http.HttpStatus;

public class ErrorResponse extends Throwable {
    public String message;
    public Integer status;

    public ErrorResponse(Integer value, String message) {
        this.status = value;
        this.message = message;
    }

    public static ErrorResponse notFound(String message) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), message);
    }

    public static ErrorResponse badRequest(String message) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), message);
    }
}
