package com.banking.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{

    @ExceptionHandler(CustomerDoesNotExistException.class)
    public ResponseEntity<Map<String,Object>> handleCustomerDoesNotExistException(CustomerDoesNotExistException ex){
        Map<String,Object> map = new HashMap<>();
        map.put("timestamp: ", LocalDateTime.now());
        map.put("message: ", ex.getMessage());
        map.put("status: ", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
}
