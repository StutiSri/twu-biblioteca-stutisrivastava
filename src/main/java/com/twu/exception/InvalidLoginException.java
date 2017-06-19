package com.twu.exception;

public class InvalidLoginException extends Throwable {
    @Override
    public String getMessage() {
        return "\nIncorrect login credentials! Please try again.";
    }
}
