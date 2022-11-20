package com.plenilune.SpringBootPractice.controller;

import com.plenilune.SpringBootPractice.exception.ProductItemNotFoundException;
import com.plenilune.SpringBootPractice.vo.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> exceptionHandlerProductItemNotFound(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
