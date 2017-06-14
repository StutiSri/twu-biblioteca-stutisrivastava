package com.twu.biblioteca;

import com.twu.outputwriter.ConsoleOutputWriter;
import com.twu.outputwriter.OutputWriter;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.StringWriter;

public class BibliotecaTest {

    @Test
    public void userShouldBeGreetedWithWelcomeMessageOnStartup(){
        StringWriter stringWriter = new StringWriter();
        OutputWriter outputWriter = new ConsoleOutputWriter(new
                BufferedWriter(stringWriter));
        new BibliotecaApp().startApplication(outputWriter);
    }

}
