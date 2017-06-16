package com.twu.biblioteca;


import com.twu.io.output.ConsoleOutput;
import com.twu.mockmodels.TestBookRepository;
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
    public void setUp() {
        quitMenuOption = "2\n";
    }

    private ConsoleOutput getExpectedWelcomeMessage() {
        List<String> expectedWelcomeMessage = new ArrayList<>();
        expectedWelcomeMessage.add("Hello User! Welcome to Biblioteca! :)\n");
        return new ConsoleOutput(expectedWelcomeMessage);
    }

    @Test
    public void userShouldBeGreetedWithWelcomeMessageOnApplicationStartup() {
        ConsoleOutput expectedWelcomeMessage = getExpectedWelcomeMessage();
        TestOutputWriter outputWriter = new TestOutputWriter();
        librarySystem = new LibrarySystem(new TestInputReader(quitMenuOption), outputWriter);

        librarySystem.run();

        ConsoleOutput welcomeMessage = outputWriter.getOutputForWelcomeMessage();
        assertEquals(expectedWelcomeMessage, welcomeMessage);
    }

    @Test
    public void userShouldGetAMenuAfterWelcomeMessage() {
        ConsoleOutput expectedMenuOptions = getExpectedMenuOptions();
        TestOutputWriter outputWriter = new TestOutputWriter();
        librarySystem = new LibrarySystem(new TestInputReader(quitMenuOption), outputWriter);

        librarySystem.run();

        ConsoleOutput menuOptions = outputWriter.getOutputForMenuAfterWelcomeMessage();
        assertEquals(expectedMenuOptions, menuOptions);
    }

    private ConsoleOutput getExpectedMenuOptions() {
        List<String> expectedMenuOptions = new ArrayList<>();
        expectedMenuOptions.add("Menu\n");
        expectedMenuOptions.add("\t1. List Books");
        expectedMenuOptions.add("\t2. Quit");
        expectedMenuOptions.add("\nPlease enter your choice : ");
        return new ConsoleOutput(expectedMenuOptions);
    }

    @Test
    public void shouldExitFromMenuWhenUserSelectsQuitOption() {
        String quitMenuOptionInput = "2";
        TestOutputWriter outputWriter = new TestOutputWriter();
        String quitMenuOptionMessage = "Thank you for using Biblioteca.";
        ConsoleOutput expectedQuitMenuOptionMessage = new ConsoleOutput(quitMenuOptionMessage);
        librarySystem = new LibrarySystem(new TestInputReader(quitMenuOptionInput), outputWriter);

        librarySystem.run();

        List<ConsoleOutput> outputMessages = outputWriter.getOutputMessagesAfterUsersChoosesAMenuOption();
        ConsoleOutput actualQuitMenuOptionMessage = outputMessages.get(0);
        assertEquals(expectedQuitMenuOptionMessage, actualQuitMenuOptionMessage);
    }

    @Test
    public void shouldKeepOnDisplayingMenuUntilUserChoosesToQuit() {
        String bookListingMenuOptionInput = "1\n";
        String quitMenuOptionInput = "2\n";
        TestOutputWriter outputWriter = new TestOutputWriter();
        librarySystem = new LibrarySystem(new TestInputReader
                (bookListingMenuOptionInput + quitMenuOptionInput), outputWriter);
        ConsoleOutput outputForListBooksMenuOption = new ConsoleOutput
                (new TestBookRepository().getBookListing());
        ConsoleOutput menuOptionsOutput = getExpectedMenuOptions();
        String quitMenuOptionMessage = "Thank you for using Biblioteca.";
        ConsoleOutput expectedQuitMenuOptionMessage = new ConsoleOutput(quitMenuOptionMessage);

        librarySystem.run();

        List<ConsoleOutput> outputMessages = outputWriter.getOutputMessagesAfterUsersChoosesAMenuOption();
        ConsoleOutput bookListingOutput = outputMessages.get(0);
        assertEquals(outputForListBooksMenuOption, bookListingOutput);

        ConsoleOutput menuOptions = outputMessages.get(1);
        assertEquals(menuOptionsOutput, menuOptions);

        ConsoleOutput actualQuitMenuOptionMessage = outputMessages.get(2);
        assertEquals(expectedQuitMenuOptionMessage, actualQuitMenuOptionMessage);
    }

}
