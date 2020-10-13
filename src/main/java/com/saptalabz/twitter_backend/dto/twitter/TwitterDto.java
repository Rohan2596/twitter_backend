package com.saptalabz.twitter_backend.dto.twitter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class TwitterDto {

    public List<StatusesDto> statuses;
    public SearchMetaData search_metadata;

    public TwitterDto(TwitterDto twitterDto) {
        this.statuses=twitterDto.statuses;
        this.search_metadata=twitterDto.search_metadata;
    }
}
