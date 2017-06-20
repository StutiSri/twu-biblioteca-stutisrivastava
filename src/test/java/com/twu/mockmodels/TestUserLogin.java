package com.twu.mockmodels;

import com.twu.biblioteca.UserLogin;
import com.twu.exception.InvalidLogoutException;
import com.twu.io.InputOutputHandler;
import com.twu.model.user.Customer;
import com.twu.model.user.Librarian;
import com.twu.model.user.LibraryUser;

public class TestUserLogin extends UserLogin {
    private final InputOutputHandler inputOutputHandler;
    private static LibraryUser loggedInUser;

    public TestUserLogin(InputOutputHandler inputOutputHandler) {
        super(null);
        this.inputOutputHandler = inputOutputHandler;
    }

    public void reset() {
        try {
            loggedInUser = null;
            logout();
        } catch (InvalidLogoutException e) {
        }
    }

    @Override
    public LibraryUser login() {
        String testCustomerLibraryNumber = "CUS-TEST";
        String testLibrarianLibraryNumber = "LIB-TEST";
        String testPassword = "test";
        String libraryNumber = inputOutputHandler.readInput();
        String password = inputOutputHandler.readInput();
        if (libraryNumber.equals(testCustomerLibraryNumber)
                && password.equals(testPassword)) {
            loggedInUser = new Customer("Test", testCustomerLibraryNumber, "test@gmail.com",
                    "xxxxxxxx", testPassword);
            return loggedInUser;
        }
        if (libraryNumber.equals(testLibrarianLibraryNumber)
                && password.equals(testPassword)) {
            loggedInUser = new Librarian(testLibrarianLibraryNumber, password);
            return loggedInUser;
        }
        return null;
    }

    public static LibraryUser getLoggedInUser() {
        return loggedInUser;
    }
}
