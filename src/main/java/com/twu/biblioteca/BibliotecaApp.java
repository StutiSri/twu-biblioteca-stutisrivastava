package com.twu.biblioteca;

import com.twu.model.menu.Library;
import com.twu.output.Output;
import com.twu.outputwriter.OutputWriter;

public class BibliotecaApp {
    public void startBiblioteca(OutputWriter outputWriter) {
        Library library = new Library();
        Output welcomeMessage = library.getWelcomeMessage();
        outputWriter.write(welcomeMessage);
    }
}
