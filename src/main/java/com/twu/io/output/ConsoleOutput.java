package com.twu.io.output;

import java.util.ArrayList;

public class ConsoleOutput implements Output {

    private ArrayList<String> outputMessages;

    public ConsoleOutput(ArrayList<String> outputMessages){
        this.outputMessages = outputMessages;
    }

    public ConsoleOutput(String outputMessage){
        outputMessages = new ArrayList<>();
        outputMessages.add(outputMessage);
    }

    @Override
    public String toString() {
        String outputMessage = "";
        for(String message : outputMessages)
            outputMessage += message + "\n";
        return outputMessage;
    }

    @Override
    public boolean equals(Object obj) {
        return toString().equals(obj.toString());
    }
}
