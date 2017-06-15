package com.twu.biblioteca;

import com.twu.output.ConsoleOutput;
import com.twu.output.Output;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class UserInterfaceTest {

    @Test
    public void userShouldGetWelcomeMessageOnApplicationStartup(){
        ArrayList<String> expectedWelcomeMessage = new ArrayList<>();
        expectedWelcomeMessage.add("Hello User! Welcome to Biblioteca! :)\n");
        Output expectedWelcomeMeesageOutput = new ConsoleOutput(expectedWelcomeMessage);
        TestOutputWriter outputWriter = new TestOutputWriter();

        new Library().openLibrary(outputWriter);
        ArrayList<Output> outputMessages = outputWriter.getOutputs();
        Output welcomeMessageOutput = outputMessages.get(0);

        assertEquals(expectedWelcomeMeesageOutput, welcomeMessageOutput);
    }

    @Test
    public void userShouldGetMenuOptionsOnApplicationStartup(){

        ArrayList<String> expectedMenuOptions = new ArrayList<>();
        expectedMenuOptions.add("Menu\n");
        expectedMenuOptions.add("\t1. List Books");
        expectedMenuOptions.add("\t2. Quit");
        expectedMenuOptions.add("\nPlease enter your choice : ");
        Output expectedMenuOptionOutput = new ConsoleOutput(expectedMenuOptions);
        TestOutputWriter outputWriter = new TestOutputWriter();

        new Library().openLibrary(outputWriter);
        ArrayList<Output> outputMessages = outputWriter.getOutputs();
        Output menuOptionOutput = outputMessages.get(1);

        assertEquals(expectedMenuOptionOutput, menuOptionOutput);
    }
}
