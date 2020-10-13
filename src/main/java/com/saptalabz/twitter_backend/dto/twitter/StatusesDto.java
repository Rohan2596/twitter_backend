package com.saptalabz.twitter_backend.dto.twitter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class StatusesDto {

    public String created_at;
    public long id;
    public String id_str;
    public String text;
    public boolean truncated;
    public UserDto user;


}
