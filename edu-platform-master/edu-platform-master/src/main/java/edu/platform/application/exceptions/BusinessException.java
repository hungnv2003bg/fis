package edu.platform.application.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class BusinessException extends RuntimeException {
    private final ResponseStatus responseStatus;
}
