package com.twu.biblioteca;

import com.twu.exception.InvalidLoginException;
import com.twu.io.InputOutputHandler;
import com.twu.mockmodels.TestInputReader;
import com.twu.mockmodels.TestLibraryRepository;
import com.twu.mockmodels.TestOutputWriter;
import com.twu.model.menuoption.ReturnBookMenuOption;
import com.twu.model.user.Customer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserLoginTest {
    @Test(expected = InvalidLoginException.class)
    public void shouldThrowExceptionForInvalidLogin() throws InvalidLoginException {
        String libraryNumber = "STU-9176\n";
        String password = "hello";
        TestInputReader inputReader = new TestInputReader(libraryNumber + password);
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(inputReader, new TestOutputWriter());
        UserLogin userLogin = new UserLogin(inputOutputHandler);
        userLogin.login();
    }

    @Test
    public void shouldProvideUserDetailsAfteSuccesfulLogin() throws InvalidLoginException {
        String libraryNumber = "STU-9176\n";
        String password = "password";
        TestInputReader inputReader = new TestInputReader(libraryNumber + password);
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(inputReader, new TestOutputWriter());
        UserLogin userLogin = new UserLogin(inputOutputHandler);
        Customer expectedUser = new Customer("Stuti", "STU-9176", "stuti@gmail.com", "9176835429", "password");

        Customer user = userLogin.login();

        assertEquals(expectedUser, user);
    }

}
