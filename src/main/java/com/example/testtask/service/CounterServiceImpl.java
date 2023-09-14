package com.example.testtask.service;

import com.example.testtask.body.ReqBody;
import com.example.testtask.exception.SymbolsValidationException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class CounterServiceImpl implements CounterService {

    private static Pattern latinLetters = Pattern.compile("^[a-zA-Z]*$");

    @Override
    public String validating(ReqBody body) {
        String letters = body.getLetters();
        if (!latinLetters.matcher(letters).find()) {
            throw new SymbolsValidationException("The letters has to be latin letters");
        }
        return letters;
    }

    @Override
    public LinkedHashMap<Character, Integer> counting(String letters) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < letters.length(); i++) {
            if (!map.containsKey(letters.charAt(i))) {
                map.put(letters.charAt(i), 1);
            } else {
                map.put(letters.charAt(i), map.get(letters.charAt(i)) + 1);
            }
        }
        LinkedHashMap<Character, Integer> result = map.entrySet().stream()
            .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new));
        return result;
    }
}
