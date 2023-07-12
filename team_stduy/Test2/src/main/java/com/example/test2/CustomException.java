package com.example.test2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomException {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity illegalException(IllegalArgumentException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
