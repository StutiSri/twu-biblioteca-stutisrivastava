package com.twu.io.output;

import java.util.ArrayList;
import java.util.List;

public class ConsoleOutput {

    private List<String> outputMessages;

    public ConsoleOutput(List<String> outputMessages) {
        this.outputMessages = outputMessages;
    }

    public ConsoleOutput(String outputMessage) {
        outputMessages = new ArrayList<>();
        outputMessages.add(outputMessage);
    }

    @Override
    public String toString() {
        String outputMessage = "";
        for (String message : outputMessages) {
            outputMessage += message;
            if (!outputMessage.contains(" : "))
                outputMessage += "\n";
        }
        return outputMessage;
    }

    @Override
    public boolean equals(Object obj) {
        return toString().equals(obj.toString());
    }
}
