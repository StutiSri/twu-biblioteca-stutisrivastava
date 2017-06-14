package com.twu.output;

public class ConsoleOutput implements Output{
    private final String outputMessage;

    public ConsoleOutput(String outputMessage){
        this.outputMessage = outputMessage;
    }

    @Override
    public String toString() {
        return outputMessage;
    }

    @Override
    public boolean equals(Object obj) {
        return toString().equals(obj.toString());
    }
}
