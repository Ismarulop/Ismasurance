package com.ismasurance.ismasurance.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ClaimNotExistException extends RuntimeException {
    private static final String code="421";
    private final HttpStatus status;

    public ClaimNotExistException(String message,HttpStatus status) {
        super(message);
        this.status = status;
    }
}
