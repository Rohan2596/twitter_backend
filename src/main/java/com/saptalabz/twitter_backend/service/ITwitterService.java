package com.saptalabz.twitter_backend.service;

import com.saptalabz.twitter_backend.dto.InputDto;

import java.util.List;

public interface ITwitterService {

    List<String> getTweetsByUsername(InputDto inputDto);
    List<String> getTweetsByTag(InputDto inputDto);
    List<String> getTweetsByBoth(InputDto inputDto);


}
