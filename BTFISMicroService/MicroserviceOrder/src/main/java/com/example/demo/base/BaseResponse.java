package com.example.demo.base;


import com.example.demo.exception.BusinessCode;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ResponseStatus;
import lombok.Data;

@Data
public class BaseResponse<T> {
    private String code;
    private String message;
    private T data;

    private BaseResponse(ResponseStatus responseStatus, T data) {
        this.code = responseStatus.getCode();
        this.message = responseStatus.getMessage();
        this.data = data;
    }

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(BusinessCode.SUCCESS, data);
    }

    public static <T> BaseResponse<T> success() {
        return new BaseResponse<>(BusinessCode.SUCCESS, null);
    }

    public static <T> BaseResponse<T> fail(BusinessException businessException) {
        return new BaseResponse<>(businessException.getResponseStatus(), null);
    }
}
