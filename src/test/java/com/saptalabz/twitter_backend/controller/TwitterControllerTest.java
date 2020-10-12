package com.saptalabz.twitter_backend.controller;

import com.google.gson.Gson;
import com.saptalabz.twitter_backend.dto.InputDto;
import org.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class TwitterControllerTest {


    @Autowired
    MockMvc mockMvc;

    private InputDto inputDto;

    String username = "@RohanKadam2596";
    List<String> getTweets;

    @Test
    public void givenValidSearchInput_whenSearchByUsername_shouldReturnValidResponse() throws Exception {

        this.getTweets = new ArrayList<>();
        this.getTweets.add(username);
        this.getTweets.add(username);
        this.inputDto = new InputDto(this.getTweets);

        MvcResult mvcResult = this.mockMvc.perform(get("/tweets/username")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.inputDto)))
                .andReturn();

        JSONArray response = new JSONArray(this.inputDto.inputList);
        Assertions.assertEquals(response.toString(), mvcResult.getResponse().getContentAsString());

    }

    @Test
    public void givenValidSearchInput_whenSearchByTag_shouldReturnValidResponse() throws Exception {
        String tag = "#developer";
        this.getTweets = new ArrayList<>();

        this.getTweets.add(tag);
        this.getTweets.add(tag);
        this.inputDto = new InputDto(this.getTweets);

        MvcResult mvcResult = this.mockMvc.perform(get("/tweets/tag")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.inputDto)))
                .andReturn();


        JSONArray response = new JSONArray(this.getTweets);
        Assertions.assertEquals(response.toString(), mvcResult.getResponse().getContentAsString());

    }

    @Test
    public void givenValidSearchInput_whenSearchByBoth_shouldReturnValidResponse() throws Exception {

        this.getTweets = new ArrayList<>();

        this.getTweets.add("developer");
        this.getTweets.add("@RohanKadam2596");
        this.inputDto = new InputDto(this.getTweets);

        MvcResult mvcResult = this.mockMvc.perform(get("/tweets/both")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.inputDto)))
                .andReturn();


        JSONArray response = new JSONArray(this.getTweets);
        Assertions.assertEquals(response.toString(), mvcResult.getResponse().getContentAsString());

    }


}
