package com.saptalabz.twitter_backend.service;

import com.saptalabz.twitter_backend.configuration.TwitterApiConfiguration;
import com.saptalabz.twitter_backend.dto.InputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TwitterServiceImplementation implements ITwitterService {


    @Autowired
    TwitterApiConfiguration twitterApiConfiguration;



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
        queryCreation(inputDto);
        return inputDto.inputList;
    }



    public void  queryCreation(InputDto inputDto){
        String query = "";
        for (String value:inputDto.inputList) {
            System.out.println(value);
            if(value.contains("@")){
                System.out.println("yes");
                String replace=value.replace("@","%40");
                query=replace+"+";
            }

        }
        System.out.println(query);
        twitterApiConfiguration.fetchTweetsFromTwitterApi(query);
    }

}
