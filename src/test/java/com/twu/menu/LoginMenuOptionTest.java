package com.twu.menu;

import com.twu.io.output.ConsoleOutput;
import com.twu.mockmodels.TestInputReader;
import com.twu.mockmodels.TestOutputWriter;
import com.twu.model.menuoption.LoginMenuOption;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginMenuOptionTest {
    @Test
    public void shouldDisplayMessageAfterSuccessfulLogin(){
        String libraryNumber = "STU-9176\n";
        String password = "password";
        TestInputReader inputReader = new TestInputReader(libraryNumber + password);
        LoginMenuOption loginMenuOption = new LoginMenuOption(inputReader, new TestOutputWriter(), null);
        String successfulMessage = "\nLogin succesful.\n";
        ConsoleOutput expectedOutput = new ConsoleOutput(successfulMessage);

        ConsoleOutput output = loginMenuOption.action();

        assertEquals(expectedOutput, output);
    }

    @Test
    public void shouldDisplayMessageAfterUnsuccessfulLogin(){
        String libraryNumber = "STU-9176\n";
        String password = "hello";
        TestInputReader inputReader = new TestInputReader(libraryNumber + password);
        LoginMenuOption loginMenuOption = new LoginMenuOption(inputReader, new TestOutputWriter(), null);
        String unsuccessfulMessage = "\nIncorrect login credentials! Please try again.\n";
        ConsoleOutput expectedOutput = new ConsoleOutput(unsuccessfulMessage);

        ConsoleOutput output = loginMenuOption.action();

        assertEquals(expectedOutput, output);
    }

}
