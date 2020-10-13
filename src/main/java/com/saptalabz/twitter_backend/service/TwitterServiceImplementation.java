package com.saptalabz.twitter_backend.service;

import com.saptalabz.twitter_backend.configuration.TwitterApiConfiguration;
import com.saptalabz.twitter_backend.dto.InputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TwitterServiceImplementation implements ITwitterService {


    @Override
    public List<String> getTweetsByUsername(InputDto inputDto) {
        return inputDto.inputList;
    }

    @Override
    public List<String> getTweetsByTag(InputDto inputDto) {
        return inputDto.inputList;
    }

    @Override
    public List<String> getTweetsByBoth(InputDto inputDto) {
        return inputDto.inputList;
    }


}
