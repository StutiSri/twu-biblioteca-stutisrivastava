package com.twu.biblioteca;

import com.twu.output.ConsoleOutput;
import com.twu.output.Output;
import com.twu.outputwriter.ConsoleOutputWriter;
import com.twu.outputwriter.OutputWriter;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ConsoleOutputWriterTest {
    @Test
    public void shouldWriteOnOutputStream(){
        StringWriter stringWriter = new StringWriter();
        OutputWriter outputWriter = new ConsoleOutputWriter(new
                BufferedWriter(stringWriter));
        String expectedOutputMessage = "Hey, This is a test.\n";
        ArrayList<String> outputMessages = new ArrayList<>();
        outputMessages.add("Hey, This is a test.");
        Output output = new ConsoleOutput(outputMessages);

        outputWriter.write(output);

        assertEquals(expectedOutputMessage, stringWriter.toString());
    }
}
