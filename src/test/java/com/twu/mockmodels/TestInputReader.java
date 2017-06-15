package com.twu.mockmodels;

import com.twu.io.input.ConsoleInput;
import com.twu.io.inputreader.InputReader;

public class TestInputReader implements InputReader {

    private String[] input;
    private int inputIndex;

    public TestInputReader(String input) {
        if (input != null)
            this.input = input.split("\n");
        inputIndex = 0;
    }

    @Override
    public ConsoleInput read() {
        return new ConsoleInput(input[inputIndex++]);
    }
}
