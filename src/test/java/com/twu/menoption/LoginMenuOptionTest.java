package com.twu.menoption;

import com.twu.io.InputOutputHandler;
import com.twu.io.output.ConsoleOutput;
import com.twu.mockmodels.TestInputReader;
import com.twu.mockmodels.TestOutputWriter;
import com.twu.model.menuoption.LoginMenuOption;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginMenuOptionTest {
    @Test
    public void shouldDisplayMessageAfterSuccessfulLogin() {
        String libraryNumber = "STU-9176\n";
        String password = "password";
        TestInputReader inputReader = new TestInputReader(libraryNumber + password);
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(inputReader, new TestOutputWriter());
        LoginMenuOption loginMenuOption = new LoginMenuOption(inputOutputHandler);
        String successfulMessage = "\nLogin successful.";
        ConsoleOutput expectedOutput = new ConsoleOutput(successfulMessage);

        ConsoleOutput output = loginMenuOption.action();

        assertEquals(expectedOutput, output);
    }

    @Test
    public void shouldDisplayMessageAfterUnsuccessfulLogin() {
        String libraryNumber = "STU-9176\n";
        String password = "hello";
        TestInputReader inputReader = new TestInputReader(libraryNumber + password);
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(inputReader, new TestOutputWriter());
        LoginMenuOption loginMenuOption = new LoginMenuOption(inputOutputHandler);
        String unsuccessfulMessage = "\nIncorrect login credentials! Please try again.";
        ConsoleOutput expectedOutput = new ConsoleOutput(unsuccessfulMessage);

        ConsoleOutput output = loginMenuOption.action();

        assertEquals(expectedOutput, output);
    }

}
