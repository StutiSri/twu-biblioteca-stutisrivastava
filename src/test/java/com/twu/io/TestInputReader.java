package com.twu.io;

import com.twu.io.input.ConsoleInput;
import com.twu.io.input.Input;
import com.twu.io.inputreader.InputReader;

public class TestInputReader implements InputReader{

    private final String input;

    public TestInputReader(String input){

        this.input = input;
    }

    @Override
    public Input read() {
        return new ConsoleInput(input);
    }
}
