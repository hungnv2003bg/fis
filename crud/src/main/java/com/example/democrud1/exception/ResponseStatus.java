package com.example.democrud1.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ResponseStatus {
    private String code;
    private String message;
    private HttpStatus httpStatus;
}
