package com.twu.biblioteca;

import com.twu.io.inputreader.ConsoleInputReader;
import com.twu.io.inputreader.InputReader;
import com.twu.io.outputwriter.ConsoleOutputWriter;
import com.twu.io.outputwriter.OutputWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BibliotecaApp {
    public static void main(String[] args) {
        OutputWriter outputWriter = new ConsoleOutputWriter(new
                BufferedWriter(new OutputStreamWriter(System.out)));

        InputReader inputReader = new ConsoleInputReader(new BufferedReader
                (new InputStreamReader(System.in)));

        new Library().startLibrary(outputWriter, inputReader);
    }
}
