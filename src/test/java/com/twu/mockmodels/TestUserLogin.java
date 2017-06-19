package com.twu.mockmodels;

import com.twu.biblioteca.UserLogin;
import com.twu.exception.InvalidLogoutException;
import com.twu.io.InputOutputHandler;

public class TestUserLogin extends UserLogin{
    public TestUserLogin(InputOutputHandler inputOutputHandler) {
        super(inputOutputHandler);
    }

    public void reset(){
        try {
            logout();
        } catch (InvalidLogoutException e) {
        }
    }

}
