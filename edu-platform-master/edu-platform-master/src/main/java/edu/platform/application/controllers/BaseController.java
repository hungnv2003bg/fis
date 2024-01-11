package edu.platform.application.controllers;

import edu.platform.application.base.model.BaseResponse;
import edu.platform.security.UserAuthentication;
import edu.platform.security.UserDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class BaseController {

    protected UserDetail getUserDetail() {
        UserAuthentication userAuthentication = (UserAuthentication) SecurityContextHolder.getContext().getAuthentication();
        UserDetail userDetails = (UserDetail) userAuthentication.getDetails();

        return userDetails;
    }

    public ResponseEntity success() {
        return ResponseEntity.ok(BaseResponse.success());
    }

    public <T> ResponseEntity<BaseResponse<T>> success(T data) {
        return ResponseEntity.ok(BaseResponse.success(data));
    }
}
