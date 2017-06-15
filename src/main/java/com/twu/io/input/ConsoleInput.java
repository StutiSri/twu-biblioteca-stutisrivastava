package com.twu.io.input;

public class ConsoleInput {
    private final String input;

    public ConsoleInput(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    @Override
    public boolean equals(Object obj) {
        return input.equals(((ConsoleInput) obj).getInput());
    }
}

