package com.twu.biblioteca;


import com.twu.model.menu.Library;
import com.twu.output.ConsoleOutput;
import com.twu.output.Output;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LibraryTest {

    @Test
    public void libraryShouldHaveAWelcomeMessage(){
        String expectedWelcomeMessage = "Hello User! Welcome to Biblioteca! :)";
        Output expectedOutput = new ConsoleOutput(expectedWelcomeMessage);

        Output output = new Library().getWelcomeMessage();

        assertEquals(expectedOutput, output);
    }
}
