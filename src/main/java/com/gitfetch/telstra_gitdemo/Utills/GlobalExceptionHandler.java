package com.gitfetch.telstra_gitdemo.Utills;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleGenericException(HttpServletRequest httpServletRequest,Exception ex){

        ErrorResourse errorResourse = new ErrorResourse();
        errorResourse.setErrorStaus(HttpStatus.BAD_REQUEST.toString());
        errorResourse.setMessage(ex.getMessage().trim());
        errorResourse.setUrl(httpServletRequest.getRequestURI().toString());
        return ResponseEntity.badRequest().body(errorResourse);
    }
}
