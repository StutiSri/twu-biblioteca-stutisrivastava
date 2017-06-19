package com.twu.io;

import com.twu.io.output.ConsoleOutput;
import com.twu.mockmodels.TestInputReader;
import com.twu.mockmodels.TestOutputWriter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputOutputHandlerTest {
    @Test
    public void shouldReadInputFromUser(){
        String inputString = "This is input.";
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(new TestInputReader(inputString), new TestOutputWriter());

        String input = inputOutputHandler.readInput();

        assertEquals(inputString, input);
    }

    @Test
    public void shouldWriteOnOutputStream(){
        TestOutputWriter testOutputWriter = new TestOutputWriter();
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(new TestInputReader(""), testOutputWriter);
        String outputMessage = "Hey, This is a test.\n";
        ConsoleOutput expectedOutput = new ConsoleOutput(outputMessage);

        inputOutputHandler.writeOutput(expectedOutput);

        assertEquals(expectedOutput, testOutputWriter.getOutput());
    }
}
