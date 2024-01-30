package com.example.demo.controller;


import com.example.demo.exception.BusinessException;
import com.example.demo.model.response.ErrorResponse;
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
//        errorResponse.setStatus(businessException.getResponseStatus().getHttpStatus());
        return new ResponseEntity(errorResponse, businessException.getResponseStatus().getHttpStatus());
    }
}
