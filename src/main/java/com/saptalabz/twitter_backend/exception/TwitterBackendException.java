package com.saptalabz.twitter_backend.exception;

public class TwitterBackendException  extends Exception{

    public  ExceptionTypes exceptionTypes;
     public   enum ExceptionTypes{
       INPUT_LIST_EMPTY("No Search Query passed in Search Field.");

       String message;
        ExceptionTypes(String message) {
            this.message=message;
        }
    }

    public TwitterBackendException( ExceptionTypes exceptionTypes) {
        this.exceptionTypes = exceptionTypes;
    }
}
