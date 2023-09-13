package com.example.testtask.service;

import com.example.testtask.body.ReqBody;
import com.example.testtask.exception.IllegalArgumentEx;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;

@Service
public class CounterServiceImpl implements CounterService {

    private static Pattern latinLetters = Pattern.compile("^[a-zA-Z]*$");

    @Override
    public String validating(ReqBody body) {
        String letters = body.getLetters();
        if (!latinLetters.matcher(letters).find()) {
            throw new IllegalArgumentEx("The letters has to be latin letters");
        }
        return letters;
    }


    @Override
    public List<String> counting(String letters) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < letters.length(); i++) {
            if (!map.containsKey(letters.charAt(i))) {
                map.put(letters.charAt(i), 1);
            } else {
                map.put(letters.charAt(i), map.get(letters.charAt(i)) + 1);
            }
        }
        List<String> result = map.entrySet().stream()
            .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
            .map(c -> c.getKey() + ":" + c.getValue())
            .toList();

        return result;
    }

}
