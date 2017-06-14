package com.twu.biblioteca;

import com.twu.model.menu.Library;
import com.twu.output.Output;
import com.twu.outputwriter.ConsoleOutputWriter;
import com.twu.outputwriter.OutputWriter;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class BibliotecaApp {

    public static void main(String[] args) {
        OutputWriter outputWriter = new ConsoleOutputWriter(new
                BufferedWriter(new OutputStreamWriter(System.out)));
        new BibliotecaApp().startBiblioteca(outputWriter);
    }

    public void startBiblioteca(OutputWriter outputWriter) {
        Library library = new Library();
        Output welcomeMessage = library.getWelcomeMessage();
        outputWriter.write(welcomeMessage);
    }
}
