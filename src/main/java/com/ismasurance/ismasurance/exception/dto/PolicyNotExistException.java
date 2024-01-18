package com.ismasurance.ismasurance.exception.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class PolicyNotExistException extends RuntimeException {
    private static final String code="420";
    private final HttpStatus status;

    public PolicyNotExistException(String message,HttpStatus status) {
        super(message);
        this.status = status;
    }


}
