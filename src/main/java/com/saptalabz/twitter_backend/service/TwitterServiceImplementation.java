package com.saptalabz.twitter_backend.service;

import com.saptalabz.twitter_backend.configuration.TwitterApiConfiguration;
import com.saptalabz.twitter_backend.dto.InputDto;
import com.saptalabz.twitter_backend.dto.twitter.StatusesDto;
import com.saptalabz.twitter_backend.dto.twitter.TwitterDto;
import com.saptalabz.twitter_backend.model.Tweet;
import com.saptalabz.twitter_backend.repository.TweetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TwitterServiceImplementation implements ITwitterService {


    @Autowired
    TwitterApiConfiguration twitterApiConfiguration;

    @Autowired
    TweetsRepository tweetsRepository;


    @Override
    public List<String> getTweetsByUsername(InputDto inputDto) {
        queryCreation(inputDto);
        return inputDto.inputList;
    }

    @Override
    public List<String> getTweetsByTag(InputDto inputDto) {
        queryCreation(inputDto);
        return inputDto.inputList;
    }

    @Override
    public List<String> getTweetsByBoth(InputDto inputDto) {
        saveToRepository(queryCreation(inputDto));
        return inputDto.inputList;
    }


    public TwitterDto queryCreation(InputDto inputDto) {
        String query = "";
        for (String value : inputDto.inputList) {
            if (value.contains("@")) {
                String replace = value.replace("@", "%40");
                query = replace + "+";
            }

        }
        return twitterApiConfiguration.fetchTweetsFromTwitterApi(query);

    }

    public Tweet saveToRepository(TwitterDto twitterDto) {
        List<Tweet> tweets = new ArrayList<>();
        for (StatusesDto statusesDto : twitterDto.statuses) {
            Tweet tweet = new Tweet(statusesDto);
            tweets.add(tweet);

        }
        System.out.println(tweets.get(0));
        return tweets.get(0);
    }
}
