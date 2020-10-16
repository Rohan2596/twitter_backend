package com.saptalabz.twitter_backend.dto;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class Response {

    public LocalDateTime createdTimeStamp=LocalDateTime.now();
    public String message;
    public Object data;


    public Response( String message,Object data) {
        this.data = data;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Response{" +
                "createdTimeStamp=" + createdTimeStamp +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
