package com.twu.io;

import com.twu.io.output.Output;
import com.twu.io.outputwriter.OutputWriter;

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
