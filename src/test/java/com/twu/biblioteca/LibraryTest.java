package com.twu.biblioteca;


import com.twu.io.output.ConsoleOutput;
import com.twu.mockmodels.TestInputReader;
import com.twu.mockmodels.TestOutputWriter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private LibrarySystem librarySystem;
    private String quitMenuOption;

    @Before
    public void setUp(){
        quitMenuOption = "2\n";
    }

    private ConsoleOutput getWelcomeMessageOutput() {
        List<String> expectedWelcomeMessage = new ArrayList<>();
        expectedWelcomeMessage.add("Hello User! Welcome to Biblioteca! :)\n");
        return new ConsoleOutput(expectedWelcomeMessage);
    }

    @Test
    public void userShouldBeGreetedWithWelcomeMessageOnApplicationStartup() {
        ConsoleOutput expectedWelcomeMessageOutput = getWelcomeMessageOutput();
        TestOutputWriter outputWriter = new TestOutputWriter();
        librarySystem = new LibrarySystem(new TestInputReader(quitMenuOption), outputWriter);

        librarySystem.run();

        ConsoleOutput welcomeMessageOutput = outputWriter.getOutputForWelcomeMessage();
        assertEquals(expectedWelcomeMessageOutput, welcomeMessageOutput);
    }

    @Test
    public void userShouldGetAMenuAfterWelcomeMessage() {
        ConsoleOutput expectedMenuOptionOutput = getMenuOptions();
        TestOutputWriter outputWriter = new TestOutputWriter();
        librarySystem = new LibrarySystem(new TestInputReader(quitMenuOption), outputWriter);

        librarySystem.run();

        ConsoleOutput menuOutput = outputWriter.getOutputForMenuAfterWelcomeMessage();
        assertEquals(expectedMenuOptionOutput, menuOutput);
    }

    private ConsoleOutput getMenuOptions() {
        List<String> expectedMenuOptions = new ArrayList<>();
        expectedMenuOptions.add("Menu\n");
        expectedMenuOptions.add("\t1. List Books");
        expectedMenuOptions.add("\t2. Quit");
        expectedMenuOptions.add("\nPlease enter your choice : ");
        return new ConsoleOutput(expectedMenuOptions);
    }

    @Test
    public void shouldPrintErrorMessageWhenInvalidMenuOptionIsSelected(){
        String invalidMenuOption = "-1\n";
        String menuOption = invalidMenuOption + quitMenuOption;
        String invalidMenuOptionAcknowledgement = "Invalid Menu Option Selected\n";
        ConsoleOutput expectedMenuOptionAcknowledgementOutput = new ConsoleOutput
                (invalidMenuOptionAcknowledgement);
        TestOutputWriter outputWriter = new TestOutputWriter();
        librarySystem = new LibrarySystem(new TestInputReader(menuOption), outputWriter);

        librarySystem.run();

        List<ConsoleOutput> outputMessages = outputWriter.getOutputMessagesAfterUsersChoosesAMenuOption();
        ConsoleOutput menuOptionAcknowledgementOutput = outputMessages.get(0);
        assertEquals(expectedMenuOptionAcknowledgementOutput, menuOptionAcknowledgementOutput);
    }

    @Test
    public void shouldExitFromMenuWhenUserSelectsQuitOption(){
        String quitMenuOption = "2";
        TestOutputWriter outputWriter = new TestOutputWriter();
        String quitMenuOptionMessage = "Thank you for using Biblioteca.";
        ConsoleOutput expectedQuitMenuOptionAcknowledgementOutput = new ConsoleOutput(quitMenuOptionMessage);
        librarySystem = new LibrarySystem(new TestInputReader(quitMenuOption), outputWriter);

        librarySystem.run();

        List<ConsoleOutput> outputMessages = outputWriter.getOutputMessagesAfterUsersChoosesAMenuOption();
        ConsoleOutput quitMenuOptionOutput = outputMessages.get(0);
        assertEquals(expectedQuitMenuOptionAcknowledgementOutput, quitMenuOptionOutput);

    }

}
