package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class BusinessCode {
    public static final ResponseStatus SUCCESS =
            new ResponseStatus("SUCCESS", "success", HttpStatus.OK);
    public static final ResponseStatus INTERNAL_SERVER_ERROR =
            new ResponseStatus("INTERNAL_SERVER_ERROR", "Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    public static final ResponseStatus TOKEN_INVALID =
            new ResponseStatus("TOKEN_INVALID", "Token invalid", HttpStatus.UNAUTHORIZED);
    public static final ResponseStatus TOKEN_EXPIRED =
            new ResponseStatus("TOKEN_EXPIRED", "Token expired", HttpStatus.UNAUTHORIZED);
    public static final ResponseStatus NOT_FOUND =
            new ResponseStatus("NOT_FOUND", "Not Found", HttpStatus.NOT_FOUND);
    private BusinessCode() {
    }
}
