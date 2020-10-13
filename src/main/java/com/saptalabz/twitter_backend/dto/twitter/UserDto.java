package com.saptalabz.twitter_backend.dto.twitter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    public long id;
    public String id_str;
    public String name;
    public String screen_name;
    public String location;
    public String profile_image_url;
    public String profile_image_url_https;


}
