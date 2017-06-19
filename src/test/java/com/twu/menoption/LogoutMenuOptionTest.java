package com.twu.menoption;

import com.twu.biblioteca.UserLogin;
import com.twu.exception.InvalidLoginException;
import com.twu.io.InputOutputHandler;
import com.twu.io.output.ConsoleOutput;
import com.twu.mockmodels.TestInputReader;
import com.twu.mockmodels.TestOutputWriter;
import com.twu.model.menuoption.LogoutMenuOption;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogoutMenuOptionTest {
    @Test
    public void shouldReturnSuccessMessageAfterSuccessfulLogout() throws InvalidLoginException {
        LogoutMenuOption logoutMenuOption = new LogoutMenuOption();
        String libraryNumber = "STU-9176\n";
        String password = "password";
        TestInputReader inputReader = new TestInputReader(libraryNumber + password);
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(inputReader, new TestOutputWriter());
        UserLogin userLogin = new UserLogin(inputOutputHandler);
        userLogin.login();
        String successfulLogoutMessage = "\nThank you for logging in. Please log in again to continue.";
        ConsoleOutput expectedOutput = new ConsoleOutput(successfulLogoutMessage);

        ConsoleOutput output = logoutMenuOption.action();

        assertEquals(expectedOutput, output);
    }

    @Test
    public void shouldReturnFailureMessageAfterUnSuccessfulLogout() throws InvalidLoginException {
        LogoutMenuOption logoutMenuOption = new LogoutMenuOption();
        TestInputReader inputReader = new TestInputReader("");
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(inputReader, new TestOutputWriter());
        UserLogin userLogin = new UserLogin(inputOutputHandler);

        String unsuccessfulLogoutMessage = "\nPlease log in to continue.";
        ConsoleOutput expectedOutput = new ConsoleOutput(unsuccessfulLogoutMessage);

        ConsoleOutput output = logoutMenuOption.action();

        assertEquals(expectedOutput, output);
    }
}
