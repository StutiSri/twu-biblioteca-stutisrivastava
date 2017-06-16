package com.twu.biblioteca;

import com.twu.io.output.ConsoleOutput;
import com.twu.mockmodels.TestInputReader;
import com.twu.mockmodels.TestOutputWriter;
import com.twu.model.menuoption.ListBooksMenuOption;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListBooksMenuOptionTest {

    @Test
    public void shouldReturnConsoleOutputRepresentationOfListOfBooks() {
        ConsoleOutput expectedBookListOutput = new ConsoleOutput
                (getBookListRepresentation());

        ConsoleOutput bookListOutput = new ListBooksMenuOption().action(new BookRepository());

        assertEquals(expectedBookListOutput, bookListOutput);
    }

    public List<String> getBookListRepresentation() {
        List<String> bookListRepresentation = new ArrayList<>();
        bookListRepresentation.add("\nAvailable Books :-\n");
        bookListRepresentation.add("Life of Pi");
        bookListRepresentation.add("Fellowship of the Ring");
        bookListRepresentation.add("---------------------------------\n");
        return bookListRepresentation;
    }

}
