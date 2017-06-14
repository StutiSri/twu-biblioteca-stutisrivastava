package com.twu.biblioteca;

import com.twu.outputwriter.ConsoleOutputWriter;
import com.twu.outputwriter.OutputWriter;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class BibliotecaApp {
    public static void main(String[] args) {
        OutputWriter outputWriter = new ConsoleOutputWriter(new
                BufferedWriter(new OutputStreamWriter(System.out)));
        new Library().startLibraryFunctions(outputWriter);
    }
}
