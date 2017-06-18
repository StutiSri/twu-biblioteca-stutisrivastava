package com.twu.biblioteca;

import com.twu.exception.InvalidLoginException;
import com.twu.mockmodels.TestBookRepository;
import com.twu.mockmodels.TestInputReader;
import com.twu.mockmodels.TestOutputWriter;
import com.twu.model.provider.CheckoutBookMenuOptionProvider;
import com.twu.model.user.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserLoginTest {
    @Test(expected = InvalidLoginException.class)
    public void shouldThrowExceptionForInvalidLogin() throws InvalidLoginException {
        String libraryNumber = "STU-9176\n";
        String password = "hello";
        TestInputReader inputReader = new TestInputReader(libraryNumber + password);
        UserLogin userLogin = new UserLogin(inputReader, new TestOutputWriter());

        userLogin.login();
    }

    @Test
    public void shouldProvideUserDetailsAfteSuccesfulLogin() throws InvalidLoginException {
        String libraryNumber = "STU-9176\n";
        String password = "password";
        TestInputReader inputReader = new TestInputReader(libraryNumber + password);
        UserLogin userLogin = new UserLogin(inputReader, new TestOutputWriter());
        User expectedUser = new User("Stuti", "STU-9176", "stuti@gmail.com", "9176835429", "password");

        User user = userLogin.login();

        assertEquals(expectedUser, user);
    }

}
