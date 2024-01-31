package com.example.demo.controller;


import com.example.demo.base.BaseResponse;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ResponseStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {

    public ResponseEntity success() {
        return ResponseEntity.ok(BaseResponse.success());
    }

    public <T> ResponseEntity<BaseResponse<T>> success(T data) {
        return ResponseEntity.ok(BaseResponse.success(data));
    }

    public ResponseEntity<BaseResponse<Void>> error(ResponseStatus status) {
        return ResponseEntity.status(status.getHttpStatus()).body(BaseResponse.fail(new BusinessException(status)));
    }

    public <T> ResponseEntity<BaseResponse<T>> error(BusinessException ex) {
        return ResponseEntity.status(ex.getResponseStatus().getHttpStatus()).body(BaseResponse.fail(ex));
    }
}
