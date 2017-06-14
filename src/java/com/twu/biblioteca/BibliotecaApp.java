package com.twu.biblioteca;

import com.twu.outputwriter.ConsoleOutputWriter;
import com.twu.outputwriter.OutputWriter;

public class BibliotecaApp {

    private static final String WELCOME_MESSAGE = "Hello User! Welcome to Biblioteca! :)";

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    public void startApplication(OutputWriter outputWriter) {
        outputWriter.write(WELCOME_MESSAGE);
    }
}
