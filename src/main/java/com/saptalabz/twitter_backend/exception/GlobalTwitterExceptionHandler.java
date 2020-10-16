package com.saptalabz.twitter_backend.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalTwitterExceptionHandler {


    @ExceptionHandler(TwitterBackendException.class)
    public String handleException(TwitterBackendException twitterBackendException ){
         return twitterBackendException.exceptionTypes.message;
    }

}
