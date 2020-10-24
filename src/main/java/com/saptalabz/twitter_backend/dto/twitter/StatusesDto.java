package com.saptalabz.twitter_backend.dto.twitter;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StatusesDto {

    public String created_at;
    public long id;
    public String id_str;
    public String text;
    public boolean truncated;
    public UserDto user;
    public ExtendedEntities extended_entities;

    public StatusesDto(String created_at, long id, String id_str, String text, boolean truncated, UserDto user, ExtendedEntities extended_entities) {
        this.created_at = created_at;
        this.id = id;
        this.id_str = id_str;
        this.text = text;
        this.truncated = truncated;
        this.user = user;
        this.extended_entities = extended_entities;
    }
}
