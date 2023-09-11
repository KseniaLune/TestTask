package com.example.testtask.service;

import com.example.testtask.body.ReqBody;
import com.example.testtask.exception.IllegalArgumentEx;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;

@Service
public class CounterServiceImpl implements CounterService {

    private static Pattern latinLetters = Pattern.compile("^[a-z]*$");

    @Override
    public String validating(ReqBody body) {
        String letters = body.getLetters();
        if (!latinLetters.matcher(letters).find()) {
            throw new IllegalArgumentEx("The letters has to be latin lower-case letters");
        }
        return letters.toLowerCase();
    }

    @Override
    public Map<Character, Integer> counting(String letters) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < letters.length(); i++) {
            if (!map.containsKey(letters.charAt(i))) {
                map.put(letters.charAt(i), 1);
            } else {
                map.put(letters.charAt(i), map.get(letters.charAt(i)) + 1);
            }
        }

        ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByValue());
        Collections.reverse(entries);

        Map<Character, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

}
