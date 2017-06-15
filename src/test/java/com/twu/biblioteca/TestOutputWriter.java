package com.twu.biblioteca;

import com.twu.output.Output;
import com.twu.outputwriter.ConsoleOutputWriter;
import com.twu.outputwriter.OutputWriter;

import java.util.ArrayList;

public class TestOutputWriter implements OutputWriter {

    ArrayList<Output> outputs;

    public TestOutputWriter(){
        outputs = new ArrayList<>();
    }

    @Override
    public void write(Output output) {
        outputs.add(output);
    }

    public ArrayList<Output> getOutputs() {
        return outputs;
    }
}
