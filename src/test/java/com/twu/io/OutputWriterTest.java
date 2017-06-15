package com.twu.io;

import com.twu.io.output.ConsoleOutput;
import com.twu.io.outputwriter.ConsoleOutputWriter;
import com.twu.io.outputwriter.OutputWriter;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class OutputWriterTest {
    @Test
    public void shouldWriteOnOutputStream(){
        StringWriter stringWriter = new StringWriter();
        OutputWriter outputWriter = new ConsoleOutputWriter(new
                BufferedWriter(stringWriter));
        String expectedOutputMessage = "Hey, This is a test.\n";
        ArrayList<String> outputMessages = new ArrayList<>();
        outputMessages.add("Hey, This is a test.");
        ConsoleOutput output = new ConsoleOutput(outputMessages);

        outputWriter.write(output);

        assertEquals(expectedOutputMessage, stringWriter.toString());
    }
}
