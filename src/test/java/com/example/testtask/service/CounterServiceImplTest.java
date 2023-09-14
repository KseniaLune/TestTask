package com.example.testtask.service;

import com.example.testtask.body.ReqBody;
import com.example.testtask.exception.SymbolsValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CounterServiceImplTest {

    @InjectMocks
    private CounterServiceImpl service;

    @Test
    void validating_shouldReturnStringFromLatinLetters_whenReqBodyIsValidAndLatinLetters() {
        //given
        String lettersValid = "aaabbccccc";
        ReqBody reqBody = new ReqBody(lettersValid);
        //when
        String result = this.service.validating(reqBody);
        //then
        assertNotNull(result);
        assertEquals(lettersValid, result);

    }

    @Test
    void validating_shouldThrowsIllegalArgumentEx_whenReqBodyIsValidAndLettersHasNOtOnlyLatinSymbols() {
        ReqBody reqBody = new ReqBody("aAabBccCcc123");

        assertThrowsExactly(SymbolsValidationException.class, () -> service.validating(reqBody));

    }

    @Test
    void counting_shouldCountingLettersAndReturnMapWithResultInDescendingOrder() {
        String letters = "aaabccccc";
        LinkedHashMap<Character, Integer> valid = new LinkedHashMap<>();
        valid.put('c',5);
        valid.put('a',3);
        valid.put('b',1);
        LinkedHashMap<Character, Integer> result = service.counting(letters);
        assertNotNull(result);
        assertEquals(valid, result);
    }
}