package com.example.demo.controller;


import com.example.demo.base.BaseResponse;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ResponseStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiHandlingController {

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<BaseResponse<Void>> handleBusinessException(BusinessException ex) {
        ResponseStatus responseStatus = ex.getResponseStatus();
        return ResponseEntity.status(responseStatus.getHttpStatus()).body(BaseResponse.fail(ex));
    }
}
