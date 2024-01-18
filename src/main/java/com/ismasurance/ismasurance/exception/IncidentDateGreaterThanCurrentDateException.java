package com.ismasurance.ismasurance.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class IncidentDateGreaterThanCurrentDateException extends RuntimeException {
    private static final  String code="419";
    private final HttpStatus status;

    public IncidentDateGreaterThanCurrentDateException(String message,HttpStatus status) {
        super(message);
        this.status = status;
    }

}
