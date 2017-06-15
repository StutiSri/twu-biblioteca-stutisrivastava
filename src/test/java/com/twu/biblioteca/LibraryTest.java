package com.twu.biblioteca;


import com.twu.mockmodels.TestInputReader;
import com.twu.mockmodels.TestOutputWriter;
import com.twu.model.menuoption.InvalidMenuOption;
import com.twu.model.menuoption.MenuOption;
import com.twu.io.output.ConsoleOutput;
import com.twu.model.menuoption.QuitMenuOption;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LibraryTest {

    private Library library;

    @Before
    public void setUp(){
        library = new Library();
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
        int firstOutputIndex = 0;

        library.openLibrary(outputWriter, new TestInputReader(null));

        ArrayList<ConsoleOutput> outputMessages = outputWriter.getOutputMessages();
        ConsoleOutput welcomeMessageOutput = outputMessages.get(firstOutputIndex);
        assertEquals(expectedWelcomeMessageOutput, welcomeMessageOutput);
    }

    @Test
    public void userShouldGetAMenuAfterWelcomeMessage() {
        ConsoleOutput expectedMenuOptionOutput = getMenuOptions();
        TestOutputWriter outputWriter = new TestOutputWriter();
        int secondOutputIndex = 1;

        library.openLibrary(outputWriter, new TestInputReader(null));

        ArrayList<ConsoleOutput> outputMessages = outputWriter.getOutputMessages();
        ConsoleOutput menuOptionOutput = outputMessages.get(secondOutputIndex);
        assertEquals(expectedMenuOptionOutput, menuOptionOutput);
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
    public void shouldGetQuitMenuOptionWhenUserSelectsQuitMenuOption() {
        String quitMenuOption = "2";
        MenuOption menuOption = library.getMenuOptionForUserChoice(quitMenuOption);
        assertTrue(menuOption instanceof QuitMenuOption);
    }

    @Test
    public void shouldGetInvalidMenuOptionWhenUserSelectsInvalidMenuOption() {
        String invalidMenuOption = "0";
        MenuOption menuOption = library.getMenuOptionForUserChoice(invalidMenuOption);
        assertTrue(menuOption instanceof InvalidMenuOption);
    }

    @Test
    public void shouldPrintErrorMessageWhenInvalidMenuOptionIsSelected() {
        String invalidMenuOption = "-1";
        String invalidMenuOptionAcknowledgement = "Invalid Menu Option Selected";
        ConsoleOutput expectedMenuOptionAcknowledgementOutput = new ConsoleOutput
                (invalidMenuOptionAcknowledgement);
        TestOutputWriter outputWriter = new TestOutputWriter();

        library.openLibrary(outputWriter, new TestInputReader(invalidMenuOption));
        ArrayList<ConsoleOutput> outputMessages = outputWriter.getOutputMessages();
        ConsoleOutput menuOptionAcknowledgementOutput = outputMessages.get(2);

        assertEquals(expectedMenuOptionAcknowledgementOutput, menuOptionAcknowledgementOutput);
    }

    @Test
    public void shouldDisplayAllBooksWhenUserSelectsListBooksMenuOption() {
        String listBooksMenuOption = "1";
        TestOutputWriter outputWriter = new TestOutputWriter();
        ConsoleOutput expectedBookListOutput = new ConsoleOutput
                (getBookListRepresentation());

        library.openLibrary(outputWriter, new TestInputReader(listBooksMenuOption));
        ArrayList<ConsoleOutput> outputMessages = outputWriter.getOutputMessages();
        ConsoleOutput bookListOutput = outputMessages.get(2);

        assertEquals(expectedBookListOutput, bookListOutput);
    }

    public List<String> getBookListRepresentation() {
        List<String> expectedBooks = new ArrayList<>();
        expectedBooks.add("\nAvailable Books :-\n");
        expectedBooks.add("Life of Pi");
        expectedBooks.add("Fellowship of the Ring");
        return expectedBooks;
    }

}
