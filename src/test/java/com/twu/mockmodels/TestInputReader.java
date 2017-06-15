package com.twu.mockmodels;

import com.twu.io.input.ConsoleInput;
import com.twu.io.inputreader.InputReader;

public class TestInputReader implements InputReader{

    private final String input;

    public TestInputReader(String input){

        this.input = input;
    }

    @Override
    public ConsoleInput read() {
        return new ConsoleInput(input);
    }
}
