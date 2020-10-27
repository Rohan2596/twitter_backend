package com.saptalabz.twitter_backend.model;

import com.saptalabz.twitter_backend.dto.twitter.StatusesDto;
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
    public String media_image_url_https;
    public LocalDateTime created_time_stamp;



    public Tweet(StatusesDto statusesDto) {
        this.id=statusesDto.id_str;
        this.text=statusesDto.text;
        this.profile_name=statusesDto.user.name;
        this.profile_screen_name=statusesDto.user.screen_name;
        this.profile_image_url=statusesDto.user.profile_image_url;
        this.profile_image_url_https=statusesDto.user.profile_image_url_https;
        this.created_time_stamp=LocalDateTime.now();
        if(statusesDto.extended_entities==null){
            this.media_image_url_https="";
        }
        if(statusesDto.extended_entities !=null){
            this.media_image_url_https=statusesDto.extended_entities.media.get(0).media_url;
        }
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", profile_name='" + profile_name + '\'' +
                ", profile_screen_name='" + profile_screen_name + '\'' +
                ", profile_image_url='" + profile_image_url + '\'' +
                ", profile_image_url_https='" + profile_image_url_https + '\'' +
                ", media_image_url_https='" + media_image_url_https + '\'' +
                ", created_time_stamp=" + created_time_stamp +
                '}';
    }
}
