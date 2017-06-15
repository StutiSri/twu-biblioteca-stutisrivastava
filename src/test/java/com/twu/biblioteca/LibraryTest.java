package com.twu.biblioteca;


import com.twu.io.TestInputReader;
import com.twu.io.TestOutputWriter;
import com.twu.model.menuoption.InvalidMenuOption;
import com.twu.model.menuoption.ListBooksMenuOption;
import com.twu.model.menuoption.MenuOption;
import com.twu.io.output.ConsoleOutput;
import com.twu.io.output.Output;
import com.twu.model.menuoption.QuitMenuOption;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LibraryTest {

    @Test
    public void userShouldBeGreetedWithWelcomeMessageOnStartup(){
        ArrayList<String> expectedWelcomeMessage = new ArrayList<>();
        expectedWelcomeMessage.add("Hello User! Welcome to Biblioteca! :)\n");
        Output expectedOutput = new ConsoleOutput(expectedWelcomeMessage);

        Output output = new Library().getWelcomeMessage();

        assertEquals(expectedOutput, output);
    }

    @Test
    public void userShouldGetWelcomeMessageOnApplicationStartup(){
        ArrayList<String> expectedWelcomeMessage = new ArrayList<>();
        expectedWelcomeMessage.add("Hello User! Welcome to Biblioteca! :)\n");
        Output expectedWelcomeMessageOutput = new ConsoleOutput(expectedWelcomeMessage);
        TestOutputWriter outputWriter = new TestOutputWriter();

        new Library().openLibrary(outputWriter, new TestInputReader(null));
        ArrayList<Output> outputMessages = outputWriter.getOutputs();
        Output welcomeMessageOutput = outputMessages.get(0);

        assertEquals(expectedWelcomeMessageOutput, welcomeMessageOutput);
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

        new Library().openLibrary(outputWriter, new TestInputReader(null));
        ArrayList<Output> outputMessages = outputWriter.getOutputs();
        Output menuOptionOutput = outputMessages.get(1);

        assertEquals(expectedMenuOptionOutput, menuOptionOutput);
    }

    @Test
    public void
    shouldGetListBooksMenuOptionWhenUserSelectsListBooksMenuOption(){
        String menuOptionInput = "1";
        TestInputReader inputReader = new TestInputReader(menuOptionInput);
        MenuOption menuOption = new Library().getMenuOptionForOption
                (menuOptionInput);

        assertTrue(menuOption instanceof ListBooksMenuOption);
    }

    @Test
    public void shouldGetQuitMenuOptionWhenUserSelectsQuitMenuOption(){
        String menuOptionInput = "2";
        TestInputReader inputReader = new TestInputReader(menuOptionInput);
        MenuOption menuOption = new Library().getMenuOptionForOption
                (menuOptionInput);

        assertTrue(menuOption instanceof QuitMenuOption);
    }

    @Test
    public void shouldGetInvalidMenuOptionWhenUserSelectsInvalidMenuOption(){
        String menuOptionInput = "0";
        TestInputReader inputReader = new TestInputReader(menuOptionInput);
        MenuOption menuOption = new Library().getMenuOptionForOption
                (menuOptionInput);

        assertTrue(menuOption instanceof InvalidMenuOption);
    }

    @Test
    public void shouldAcknowledgeMenuOptionSelectedByUser(){
        String menuOptionInput = "1";
        ArrayList<String> expectedMenuOptionAcknowledgement = new ArrayList<>();
        expectedMenuOptionAcknowledgement.add("List Books");
        Output expectedMenuOptionAcknowledgementOutput = new ConsoleOutput
                (expectedMenuOptionAcknowledgement);
        TestOutputWriter outputWriter = new TestOutputWriter();

        new Library().openLibrary(outputWriter, new TestInputReader(menuOptionInput));
        ArrayList<Output> outputMessages = outputWriter.getOutputs();
        Output menuOptionAcknowledgementOutput = outputMessages.get(2);

        assertEquals(expectedMenuOptionAcknowledgementOutput, menuOptionAcknowledgementOutput);
    }

    @Test
    public void shouldPrintErrorMessageWhenInvalidMenuOptionIsSelected(){
        String menuOptionInput = "-1";
        ArrayList<String> expectedMenuOptionAcknowledgement = new ArrayList<>();
        expectedMenuOptionAcknowledgement.add("Invalid Menu Option Selected");
        Output expectedMenuOptionAcknowledgementOutput = new ConsoleOutput
                (expectedMenuOptionAcknowledgement);
        TestOutputWriter outputWriter = new TestOutputWriter();

        new Library().openLibrary(outputWriter, new TestInputReader(menuOptionInput));
        ArrayList<Output> outputMessages = outputWriter.getOutputs();
        Output menuOptionAcknowledgementOutput = outputMessages.get(2);

        assertEquals(expectedMenuOptionAcknowledgementOutput, menuOptionAcknowledgementOutput);
    }

}
