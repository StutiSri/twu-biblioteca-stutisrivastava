package com.twu.mockmodels;

import com.twu.io.output.ConsoleOutput;
import com.twu.io.outputwriter.OutputWriter;

import java.util.ArrayList;

public class TestOutputWriter implements OutputWriter {

    ArrayList<ConsoleOutput> outputMessages;

    public TestOutputWriter(){
        outputMessages = new ArrayList<>();
    }

    @Override
    public void write(ConsoleOutput output) {
        outputMessages.add(output);
    }

    public ArrayList<ConsoleOutput> getOutputMessages() {
        return outputMessages;
    }
}
