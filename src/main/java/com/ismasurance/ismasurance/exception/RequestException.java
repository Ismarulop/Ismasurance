package com.ismasurance.ismasurance.exception;


import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class RequestException extends RuntimeException {
    private final String code;
    private final HttpStatus status;

    public RequestException(String message,HttpStatus status, String code) {
        super(message);
        this.code = code;
        this.status = status;
    }
}
