package com.example.validation.advice;

import com.example.validation.exception.userNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException methodArgumentNotValidException)
    {
        Map<String,String> errorMap = new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getFieldErrors()
                .forEach(error->errorMap.put(error.getField(),error.getDefaultMessage()));
        return errorMap;
    }
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    @ExceptionHandler(NullPointerException.class)
    public Map<String,String> handleNullPointerException(NullPointerException nullPointerException)
    {
        Map<String,String> nullEx = new HashMap<>();
        nullEx.put("Null Pointer Exception",nullPointerException.getMessage());
        return nullEx;
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(userNotFoundException.class)
    public  Map<String,String> handleUserNotFoundException(userNotFoundException ex)
    {
    Map<String,String> userError = new HashMap<>();
    userError.put("error message",ex.getMessage());
    return userError;
    }
}
