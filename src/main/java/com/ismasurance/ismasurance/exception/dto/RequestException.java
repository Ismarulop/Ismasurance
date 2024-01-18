package com.ismasurance.ismasurance.exception.dto;


import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class RequestException extends RuntimeException {
    private static final String code= "418";
    private final HttpStatus status;

    public RequestException(String message,HttpStatus status) {
        super(message);

        this.status = status;
    }
}
