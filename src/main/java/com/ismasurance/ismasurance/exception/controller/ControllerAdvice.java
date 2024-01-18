package com.ismasurance.ismasurance.exception.controller;

import com.ismasurance.ismasurance.exception.dto.PolicyNotExistException;
import com.ismasurance.ismasurance.exception.dto.RequestException;
import com.ismasurance.ismasurance.exception.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value= RequestException.class)
    public ResponseEntity<ErrorDTO> requestExceptionHandler(RequestException exception) {
        ErrorDTO requestException = ErrorDTO.builder()
                .code(exception.getCode())
                .message(exception.getMessage())
                .status(exception.getStatus())
                .build();
        return new ResponseEntity<>(requestException, exception.getStatus());
    }

    @ExceptionHandler(value= PolicyNotExistException.class)
    public ResponseEntity<ErrorDTO> policyNotExistException(PolicyNotExistException exception) {
        ErrorDTO requestException = ErrorDTO.builder()
                .code(exception.getCode())
                .message(exception.getMessage())
                .status(exception.getStatus())
                .build();
        return new ResponseEntity<>(requestException, exception.getStatus());
    }
}
