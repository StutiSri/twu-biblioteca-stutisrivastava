package com.twu.biblioteca;

import com.twu.outputwriter.ConsoleOutputWriter;
import com.twu.outputwriter.OutputWriter;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) {
        OutputWriter outputWriter = new ConsoleOutputWriter(new
                BufferedWriter(new OutputStreamWriter(System.out)));
        new BibliotecaApp().startBiblioteca(outputWriter);
    }
}
