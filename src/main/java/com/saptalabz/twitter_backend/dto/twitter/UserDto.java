package com.saptalabz.twitter_backend.dto.twitter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserDto {

    public UserDto(long id, String id_str, String name, String screen_name, String location, String profile_image_url, String profile_image_url_https) {
        this.id = id;
        this.id_str = id_str;
        this.name = name;
        this.screen_name = screen_name;
        this.location = location;
        this.profile_image_url = profile_image_url;
        this.profile_image_url_https = profile_image_url_https;
    }

    public long id;
    public String id_str;
    public String name;
    public String screen_name;
    public String location;
    public String profile_image_url;
    public String profile_image_url_https;


}
