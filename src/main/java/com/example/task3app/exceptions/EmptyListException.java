package com.example.task3app.exceptions;

public class EmptyListException extends Exception {
    public EmptyListException() {
    }

    public EmptyListException(String message) {
        super(message);
    }
}
