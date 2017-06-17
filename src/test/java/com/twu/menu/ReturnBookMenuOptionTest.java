package com.twu.menu;

import com.twu.biblioteca.BookRepository;
import com.twu.io.input.ConsoleInput;
import com.twu.io.output.ConsoleOutput;
import com.twu.mockmodels.TestBookRepository;
import com.twu.mockmodels.TestInputReader;
import com.twu.mockmodels.TestOutputWriter;
import com.twu.model.menuoption.ReturnBookMenuOption;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReturnBookMenuOptionTest {
    @Test
    public void shouldInformUserAfterASuccessfulReturn(){
        String titleOfBook = "atlas shrugged";
        TestBookRepository testBookRepository = new TestBookRepository();
        testBookRepository.checkoutBook(titleOfBook);
        ReturnBookMenuOption returnBookMenuOption = new ReturnBookMenuOption
                (new ConsoleInput(titleOfBook));
        String successfulReturnMessage = "\nThank you for returning the book.\n";
        ConsoleOutput expectedOutput = new ConsoleOutput(successfulReturnMessage);

        ConsoleOutput output = returnBookMenuOption.action(testBookRepository);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void shouldInformUserAfterAnUnsuccessfulReturn(){
        String titleOfBook = "game of thrones";
        TestBookRepository testBookRepository = new TestBookRepository();
        testBookRepository.checkoutBook(titleOfBook);
        ReturnBookMenuOption returnBookMenuOption = new ReturnBookMenuOption
                (new ConsoleInput(titleOfBook));
        String unsuccessfulReturnMessage = "\nThat is not a valid book to return.\n";
        ConsoleOutput expectedOutput = new ConsoleOutput(unsuccessfulReturnMessage);

        ConsoleOutput output = returnBookMenuOption.action(testBookRepository);

        assertEquals(expectedOutput, output);
    }
}
