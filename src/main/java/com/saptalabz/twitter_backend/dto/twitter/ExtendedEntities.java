package com.saptalabz.twitter_backend.dto.twitter;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class ExtendedEntities {

    public List<Media> media=new ArrayList<>();
    public int size;

    public ExtendedEntities(List<Media> media) {
        this.media = media;
        this.size=media.size();
    }
}
