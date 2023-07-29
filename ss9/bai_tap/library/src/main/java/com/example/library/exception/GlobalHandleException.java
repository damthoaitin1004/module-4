package com.example.library.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandleException {
    @ExceptionHandler(Exception.class)
    public String handleArithmetic(){
        return "errors";
    }
}
