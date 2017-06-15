package com.twu.io.outputwriter;

import com.twu.io.output.ConsoleOutput;

import java.io.BufferedWriter;
import java.io.IOException;

public class ConsoleOutputWriter implements OutputWriter {

    private final BufferedWriter bufferedWriter;

    public ConsoleOutputWriter(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    @Override
    public void write(ConsoleOutput output) {
        try {
            bufferedWriter.write(output.toString());
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
