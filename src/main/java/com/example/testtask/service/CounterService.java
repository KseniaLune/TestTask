package com.example.testtask.service;

import com.example.testtask.body.ReqBody;

import javax.swing.text.AttributeSet;
import java.util.Map;

public interface CounterService {

    String validating(ReqBody body);

    Map<Character, Integer> counting(String letters);
}
