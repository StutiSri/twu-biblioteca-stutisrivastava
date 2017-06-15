package com.twu.biblioteca;


import com.twu.model.menuoption.MenuOption;
import com.twu.output.ConsoleOutput;
import com.twu.output.Output;
import com.twu.outputwriter.ConsoleOutputWriter;
import com.twu.outputwriter.OutputWriter;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

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
    public void
    shouldGetListBooksMenuOptionWhenUserSelectsListBooksMenuOption(){
        MenuOption menuOption = new Library().getMenuOptionForOption("1");

    }

}
