package com.example.testtask.controller;

import com.example.testtask.exception.ExBody;
import com.example.testtask.exception.SymbolsValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(SymbolsValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExBody handleIllegalArgument(SymbolsValidationException ex) {
        return new ExBody(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExBody handlerMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        ExBody exBody = new ExBody("Validation failed.");
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<String> list = fieldErrors.stream()
            .map(FieldError::getDefaultMessage)
            .toList();
        exBody.setErrors(list);
        return exBody;
    }


}
