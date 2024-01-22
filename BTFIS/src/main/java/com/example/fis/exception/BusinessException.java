package com.example.fis.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BusinessException extends RuntimeException {
   private final ResponseStatus responseStatus;
}
