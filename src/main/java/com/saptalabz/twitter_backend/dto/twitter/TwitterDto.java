package com.saptalabz.twitter_backend.dto.twitter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class TwitterDto {

    public List<StatusesDto> statuses;
    public SearchMetaData search_metadata;

    public TwitterDto(List<StatusesDto> statuses, SearchMetaData search_metadata) {
        this.statuses = statuses;
        this.search_metadata = search_metadata;
    }
}
