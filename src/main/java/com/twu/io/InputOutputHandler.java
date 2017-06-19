package com.twu.io;

import com.twu.io.input.ConsoleInput;
import com.twu.io.inputreader.InputReader;
import com.twu.io.output.ConsoleOutput;
import com.twu.io.outputwriter.OutputWriter;

public class InputOutputHandler {

    private final InputReader inputReader;
    private final OutputWriter outputWriter;

    public InputOutputHandler(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }

    public String readInput(){
        return inputReader.read().getInput();
    }

    public void writeOutput(ConsoleOutput output){
        outputWriter.write(output);
    }
}
