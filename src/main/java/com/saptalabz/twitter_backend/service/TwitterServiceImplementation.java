package com.saptalabz.twitter_backend.service;

import com.saptalabz.twitter_backend.configuration.TwitterApiConfiguration;
import com.saptalabz.twitter_backend.dto.*;
import com.saptalabz.twitter_backend.dto.twitter.*;
import com.saptalabz.twitter_backend.exception.TwitterBackendException;
import com.saptalabz.twitter_backend.model.Tweet;
import com.saptalabz.twitter_backend.repository.TweetsRepository;
import com.saptalabz.twitter_backend.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/*
 * @author  Rohan Kadam
 * @purpose TwitterService Implementation for logic getting tweets from repository.
 *
 * */
@Service
public class TwitterServiceImplementation implements ITwitterService {

    @Autowired
    TwitterApiConfiguration twitterApiConfiguration;

    @Autowired
    TweetsRepository tweetsRepository;

    @Autowired
    RedisUtil redisUtil;


    @Override
    public List<Tweet> getTweetsByUsername(InputDto inputDto) throws TwitterBackendException {
        inputEmptyCheck(inputDto);
        saveToRepository(queryCreationByUsername(inputDto));
        return tweetsRepository.findAll();
    }

    @Override
    public List<Tweet> getTweetsByTag(InputDto inputDto) throws TwitterBackendException {
        inputEmptyCheck(inputDto);
        saveToRepository(queryCreationByTag(inputDto));

        return tweetsRepository.findAll();
    }

    @Override
    public List<Tweet> getTweetsByBoth(InputDto inputDto) throws TwitterBackendException {
        inputEmptyCheck(inputDto);
        saveToRepository(queryCreation(inputDto));
        return tweetsRepository.findAll();
    }


    public TwitterDto queryCreation(InputDto inputDto) {
        String query = "";
        for (String value : inputDto.inputList) {
            if (value.contains("@")) {
                String replace = value.replace("@", "%40");
                query = replace + "+";
            }
            if (value.contains("#")) {
                String replace = value.replace("#", "%23");
                query = replace + "+";
            }

        }

        return twitterApiConfiguration.fetchTweetsFromTwitterApi(query);

    }

    public TwitterDto queryCreationByTag(InputDto inputDto) throws TwitterBackendException {
        String query = "";
        for (String value : inputDto.inputList) {
            if (value.contains("#")) {
                String replace = value.replace("#", "%23");
                query = replace + "+";
            }
            if(!value.contains("#"))
            {
                throw new TwitterBackendException(TwitterBackendException.ExceptionTypes.INVALID_QUERY_ADDED);

            }
        }
        return twitterApiConfiguration.fetchTweetsFromTwitterApi(query);

    }

    public TwitterDto queryCreationByUsername(InputDto inputDto) throws TwitterBackendException {
        String query = "";
        for (String value : inputDto.inputList) {
            if (value.contains("@")) {
                String replace = value.replace("@", "%40");
                query = replace + "+";
            } else {
                throw new TwitterBackendException(TwitterBackendException.ExceptionTypes.INVALID_QUERY_ADDED);

            }
        }
        return twitterApiConfiguration.fetchTweetsFromTwitterApi(query);

    }

    public Tweet saveToRepository(TwitterDto twitterDto) {
        List<Tweet> tweets = new ArrayList<>();
        for (StatusesDto statusesDto : twitterDto.statuses) {
            Tweet tweet = new Tweet(statusesDto);
            tweets.add(tweet);
            tweetsRepository.save(tweet);

        }
        return tweets.get(0);
    }

    public void inputEmptyCheck(InputDto inputDto) throws TwitterBackendException {
        if (inputDto.inputList.size() == 0) {
            throw new TwitterBackendException(TwitterBackendException.ExceptionTypes.INPUT_LIST_EMPTY);
        }
    }
}
