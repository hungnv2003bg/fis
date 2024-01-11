package com.example.democrud1.controller;

import com.example.democrud1.exception.BusinessException;
import com.example.democrud1.model.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiHandlingController {

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<?> handleException(BusinessException businessException) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(businessException.getResponseStatus().getCode());
        errorResponse.setMessage(businessException.getResponseStatus().getMessage());
        return new ResponseEntity(errorResponse, businessException.getResponseStatus().getHttpStatus());
    }
}
