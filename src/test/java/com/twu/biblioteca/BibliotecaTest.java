package com.twu.biblioteca;

import com.twu.model.menu.Library;
import com.twu.model.provider.MenuHandler;
import com.twu.output.ConsoleOutput;
import com.twu.output.Output;
import com.twu.outputwriter.ConsoleOutputWriter;
import com.twu.outputwriter.OutputWriter;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    @Test
    public void userShouldBeGreetedWithWelcomeMessageOnStartup(){
        StringWriter stringWriter = new StringWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
        OutputWriter outputWriter = new ConsoleOutputWriter(bufferedWriter);

        new BibliotecaApp().startBiblioteca(outputWriter);

        String expectedWelcomeMessage = "Hello User! Welcome to Biblioteca! :)";

        assertEquals(expectedWelcomeMessage, stringWriter.toString());
    }

    @Test
    public void userShouldGetMenuOnApplicationStartup(){
        String expectedMessage = "Hello User! Welcome to Biblioteca! :)" +
                "\n\nMain Menu\n\n\t1. List Books\n\t2. Quit\n\nPlease enter " +
                "your choice" +
                " : ";
        ConsoleOutput expectedOutput = new ConsoleOutput(expectedMessage);

        Output output = new MenuHandler().getMenuOptions();

        //assertEquals(expectedOutput, output);
    }
}
