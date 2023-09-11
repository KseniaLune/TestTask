package com.example.testtask.controller;

import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class ControllerIT {

    @InjectMocks
    private MockMvc mockMvc;

    void countingLetter() throws Exception {

        MockHttpServletRequestBuilder request = post("/api/counting")
            .contentType(MediaType.APPLICATION_JSON)
            .content("""
                {
                "letters": "aaabbccccc"
                }
                """);
        this.mockMvc.perform(request)
            .andExpectAll(
                status().isOk(),
                content().contentType(MediaType.APPLICATION_JSON),
                content().json("""
                    {
                         "result": {
                             "c": 5,
                             "a": 3,
                             "b": 2
                         }
                     }
                    """)
            );
    }

}