package com.example.testtask.body;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class ExBody {
    private String message;
    private Map<String, String> error;

    public ExBody(String message) {
        this.message = message;
    }
}
