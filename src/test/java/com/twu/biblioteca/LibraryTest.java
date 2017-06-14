package com.twu.biblioteca;


import com.twu.output.ConsoleOutput;
import com.twu.output.Output;
import com.twu.outputwriter.ConsoleOutputWriter;
import com.twu.outputwriter.OutputWriter;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    @Test
    public void userShouldBeGreetedWithWelcomeMessageOnStartup(){
        StringWriter stringWriter = new StringWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
        OutputWriter outputWriter = new ConsoleOutputWriter(bufferedWriter);

        new Library().startLibraryFunctions(outputWriter);

        String expectedWelcomeMessage = "Hello User! Welcome to Biblioteca! " +
                ":)\n";

        assertEquals(expectedWelcomeMessage, stringWriter.toString());
    }

    @Test
    public void userShouldGetMenuOnApplicationStartup(){
        String expectedMessage = "Hello User! Welcome to Biblioteca! :)" +
                "\n\nMain MenuOption\n\n\t1. List Books\n\t2. Quit\n\nPlease enter " +
                "your choice" +
                " : ";
        ConsoleOutput expectedOutput = new ConsoleOutput(expectedMessage);

        Output output = new Menu().getMenuOptions();

        //assertEquals(expectedOutput, output);
    }
}
