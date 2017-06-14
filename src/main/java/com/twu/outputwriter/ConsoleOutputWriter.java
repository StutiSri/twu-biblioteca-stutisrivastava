package com.twu.outputwriter;

import com.twu.output.Output;

import java.io.BufferedWriter;
import java.io.IOException;

public class ConsoleOutputWriter implements OutputWriter {

    private final BufferedWriter bufferedWriter;

    public ConsoleOutputWriter(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    @Override
    public void write(Output output) {
        try {
            bufferedWriter.write(output.toString());
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
