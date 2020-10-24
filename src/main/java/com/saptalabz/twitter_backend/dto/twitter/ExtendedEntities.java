package com.saptalabz.twitter_backend.dto.twitter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class ExtendedEntities {

    public List<Media> media=new ArrayList<>();

    public ExtendedEntities(List<Media> media) {
        this.media = media;
    }
}
