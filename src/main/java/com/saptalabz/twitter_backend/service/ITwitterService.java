package com.saptalabz.twitter_backend.service;

import com.saptalabz.twitter_backend.dto.InputDto;
import com.saptalabz.twitter_backend.model.Tweet;

import java.util.List;

public interface ITwitterService {

    List<Tweet> getTweetsByUsername(InputDto inputDto);

    List<Tweet> getTweetsByTag(InputDto inputDto);

    List<Tweet> getTweetsByBoth(InputDto inputDto);


}
