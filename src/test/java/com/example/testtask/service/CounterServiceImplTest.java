package com.example.testtask.service;

import com.example.testtask.body.ReqBody;
import com.example.testtask.body.RespBody;
import com.example.testtask.exception.IllegalArgumentEx;
import io.swagger.v3.oas.annotations.media.DependentRequired;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

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

        assertThrowsExactly(IllegalArgumentEx.class, () -> service.validating(reqBody));

    }

    @Test
    void counting_shouldCountingLettersAndReturnMapWithResultInDescendingOrder() {
        String letters = "aaabccccc";
        List<String> valid = List.of("c:5","a:3","b:1");

        List<String> result = service.counting(letters);
        assertNotNull(result);
        assertEquals(valid, result);
    }
}