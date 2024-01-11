package edu.platform.application.controllers;

import edu.platform.application.base.model.BaseResponse;
import edu.platform.application.exceptions.BusinessException;
import edu.platform.application.exceptions.ResponseStatus;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class ApiHandleExceptionController {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<BaseResponse<ResponseStatus>> handleUrlExisted(BusinessException businessException) {
        return new ResponseEntity<>(BaseResponse.fail(businessException), businessException.getResponseStatus().getStatus());
    }
}
