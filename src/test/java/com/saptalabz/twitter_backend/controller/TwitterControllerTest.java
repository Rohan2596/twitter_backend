package com.saptalabz.twitter_backend.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class TwitterControllerTest {


    @Autowired
    MockMvc mockMvc;

    @Test
    public void givenValidSearchInput_whenSearchByUsername_shouldReturnValidResponse() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/tweets")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("username", "@RohanKadam2596")).andReturn();
        Assertions.assertEquals("@RohanKadam2596", mvcResult.getResponse().getContentAsString());

    }
}
