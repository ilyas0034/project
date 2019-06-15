package com.guleni.project.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
/*

Bu class bizim api mızın herhangi bir exception oluştuğunda bu formatı kendi belirlediğimiz formata dönüşmesini sağlyacak
 */
@ControllerAdvice
@RestController
public class IMExceptionHandler {


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<?> handlerException(Exception ex, WebRequest request)
    {
        ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(),ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.EXPECTATION_FAILED);
    }
}
