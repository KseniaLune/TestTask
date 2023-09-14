package com.example.testtask;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc(printOnlyOnFailure = false)
class ControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void countingLetter_shouldCountingLetters_whenRequestIsValid() throws Exception {
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
                        "result":{"c":5,"a":3,"b":2}
                     }
                    """)
            );
    }
    @Test
    void countingLetter_shouldThrowsException_whenRequestIsValidNotLatin() throws Exception {
        MockHttpServletRequestBuilder request = post("/api/counting")
            .contentType(MediaType.APPLICATION_JSON)
            .content("""
                {
                "letters": "aaabbccccc123"
                }
                """);
        this.mockMvc.perform(request)
            .andExpectAll(
                status().isBadRequest(),
                content().contentType(MediaType.APPLICATION_JSON),
                content().json("""
                    {
                        "message": "The letters has to be latin letters",
                        "errors": null
                    }
                    """)
            );
    }
    @Test
    void countingLetter_shouldThrowsValidationException_whenRequestIsBlank() throws Exception {
        MockHttpServletRequestBuilder request = post("/api/counting")
            .contentType(MediaType.APPLICATION_JSON)
            .content("""
                {
                "letters": "   "
                }
                """);
        this.mockMvc.perform(request)
            .andExpectAll(
                status().isBadRequest(),
                content().contentType(MediaType.APPLICATION_JSON),
                content().json("""
                    {
                        "message": "Validation failed.",
                        "errors": [
                            "Letters must be not blank."
                        ]
                    }
                    """)
            );
    }
    @Test
    void countingLetter_shouldThrowsValidationException_whenRequestIsNull() throws Exception {
        MockHttpServletRequestBuilder request = post("/api/counting")
            .contentType(MediaType.APPLICATION_JSON)
            .content("""
                {
                "letters": null
                }
                """);
        this.mockMvc.perform(request)
            .andExpectAll(
                status().isBadRequest(),
                content().contentType(MediaType.APPLICATION_JSON),
                content().json("""
                    {
                        "message": "Validation failed.",
                        "errors": [
                            "Letters must be not null.",
                            "Letters must be not blank."
                        ]
                    }
                    """)
            );
    }

}