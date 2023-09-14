package com.example.testtask.controller;

import com.example.testtask.body.ReqBody;
import com.example.testtask.body.RespBody;
import com.example.testtask.service.CounterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "Main Controller")
public class Controller {
    private final CounterService service;

    @PostMapping("/counting")
    @Operation(summary = "Counting letter")
    public ResponseEntity<RespBody> countingLetter(@Valid @RequestBody ReqBody body) {

        String validatingLetters = service.validating(body);
        LinkedHashMap<Character, Integer> pairs = service.counting(validatingLetters);

        return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(new RespBody(pairs));
    }
}
