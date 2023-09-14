package com.example.testtask.service;

import com.example.testtask.body.ReqBody;

import java.util.LinkedHashMap;

public interface CounterService {

    String validating(ReqBody body);

    LinkedHashMap<Character, Integer> counting(String letters);
}
