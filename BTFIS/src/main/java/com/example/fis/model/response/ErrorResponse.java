package com.example.fis.model.response;

import lombok.Data;

@Data
public class ErrorResponse {
    private String code;
    private String message;
}
