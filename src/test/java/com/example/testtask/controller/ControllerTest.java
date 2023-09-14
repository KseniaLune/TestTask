package com.example.testtask.controller;

import com.example.testtask.body.ReqBody;
import com.example.testtask.body.RespBody;
import com.example.testtask.service.CounterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ControllerTest {
    @Mock
    private CounterService service;

    @InjectMocks
    private Controller controller;

    @Test
    void countingLetter() {
        String letters = "aaabbccccc";
        ReqBody reqBody = new ReqBody(letters);
        when(service.validating(reqBody)).thenReturn(letters);
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        map.put('c',5);
        map.put('a',3);
        map.put('b',2);
        when(service.counting(letters)).thenReturn(map);
        RespBody respBody = new RespBody(map);

        ResponseEntity<RespBody> actual = controller.countingLetter(reqBody);

        assertNotNull(actual);
        assertEquals(HttpStatus.OK, actual.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, actual.getHeaders().getContentType());
        assertEquals(respBody, actual.getBody());

        verify(service).validating(reqBody);
        verify(service).counting(letters);

    }
}