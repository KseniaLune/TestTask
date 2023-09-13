package com.example.testtask.service;

import com.example.testtask.body.ReqBody;

import java.util.List;

public interface CounterService {

    String validating(ReqBody body);

    List<String> counting(String letters);
}
