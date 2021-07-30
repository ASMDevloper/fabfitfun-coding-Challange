package com.challenge.fabfitfun.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.challenge.fabfitfun.services.AdminOnlyException;


@ControllerAdvice
public class AdminOnlyExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({AdminOnlyException.class})
    public ResponseEntity<Object> handleNotFoundException(Exception exception, WebRequest request){

        return new ResponseEntity<Object>("Only ADMIN may create new users", new HttpHeaders(), HttpStatus.NOT_FOUND);

    }
}
