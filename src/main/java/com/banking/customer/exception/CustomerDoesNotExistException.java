package com.banking.customer.exception;

public class CustomerDoesNotExistException extends RuntimeException {
    public CustomerDoesNotExistException(String message) {
        super(message);
    }
}
