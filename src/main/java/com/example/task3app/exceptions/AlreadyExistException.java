package com.example.task3app.exceptions;

public class AlreadyExistException extends Exception {
    public AlreadyExistException() {
    }

    public AlreadyExistException(String message) {
        super(message);
    }
}
