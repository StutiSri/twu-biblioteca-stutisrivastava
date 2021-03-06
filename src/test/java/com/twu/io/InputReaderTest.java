package com.twu.io;

import com.twu.io.input.ConsoleInput;
import com.twu.io.inputreader.ConsoleInputReader;
import com.twu.io.inputreader.InputReader;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

public class InputReaderTest {
    @Test
    public void shouldReadInputFromUser(){
        String inputString = "This is input.";
        InputReader inputReader = new ConsoleInputReader(new BufferedReader
                (new StringReader(inputString)));
        ConsoleInput expectedInput = new ConsoleInput(inputString);

        ConsoleInput input = inputReader.read();

        assertEquals(expectedInput, input);
    }
}
