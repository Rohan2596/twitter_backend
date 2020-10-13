package com.saptalabz.twitter_backend.model;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@NoArgsConstructor
public class Tweet {

    @Id
    public String id;
    public String text;
    public String profile_name;
    public String profile_screen_name;
    public String profile_image_url;
    public String profile_image_url_https;
    public LocalDateTime created_time_stamp = LocalDateTime.now();




}
