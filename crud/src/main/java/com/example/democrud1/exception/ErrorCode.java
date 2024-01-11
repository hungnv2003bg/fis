package com.example.democrud1.exception;

import org.springframework.http.HttpStatus;

public class ErrorCode {
    public static ResponseStatus USER_NOT_FOUND = new ResponseStatus("USER_NOT_FOUND", "User not found!", HttpStatus.NOT_FOUND);
    public static ResponseStatus USER_NAME_NOT_BLANK = new ResponseStatus("USER_NAME_NOT_BLANK", "User name can not blacnk!", HttpStatus.BAD_REQUEST);
    public static ResponseStatus AGE_CAN_NOT_NEGATIVE = new ResponseStatus("INTERNAL_SERVER_ERROR", "Age can not negative!", HttpStatus.INTERNAL_SERVER_ERROR);
    public static ResponseStatus AGE_NOT_BLANK = new ResponseStatus("AGE_NOT_BLANK", "Age can not blank!", HttpStatus.INTERNAL_SERVER_ERROR);

}