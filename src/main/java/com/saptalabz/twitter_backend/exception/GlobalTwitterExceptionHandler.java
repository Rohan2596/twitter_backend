package com.saptalabz.twitter_backend.exception;

import com.saptalabz.twitter_backend.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalTwitterExceptionHandler {


    @ExceptionHandler(TwitterBackendException.class)
    public ResponseEntity<Response> handleException(TwitterBackendException twitterBackendException ){
         return new ResponseEntity<Response>( new  Response("Exception Thrown",twitterBackendException.exceptionTypes.message), HttpStatus.BAD_REQUEST);
    }

}
