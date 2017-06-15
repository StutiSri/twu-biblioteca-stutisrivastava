package com.twu.io.inputreader;

import com.twu.io.input.ConsoleInput;

import java.io.BufferedReader;
import java.io.IOException;

public class ConsoleInputReader implements InputReader {
    private final BufferedReader bufferedReader;

    public ConsoleInputReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public ConsoleInput read() {
        try {
            String line = bufferedReader.readLine();
            return new ConsoleInput(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
