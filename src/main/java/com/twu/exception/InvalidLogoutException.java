package com.twu.exception;

public class InvalidLogoutException extends Exception {
    @Override
    public String getMessage() {
        return "\nPlease log in to continue.";
    }
}
