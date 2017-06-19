package com.twu.menoption;

import com.twu.io.InputOutputHandler;
import com.twu.io.input.ConsoleInput;
import com.twu.io.output.ConsoleOutput;
import com.twu.mockmodels.TestInputReader;
import com.twu.mockmodels.TestLibraryRepository;
import com.twu.mockmodels.TestOutputWriter;
import com.twu.model.menuoption.ReturnBookMenuOption;
import com.twu.model.user.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReturnBookMenuOptionTest {

    @Test
    public void shouldInformUserAfterASuccessfulReturn(){
        String titleOfBook = "atlas shrugged";
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(new TestInputReader(titleOfBook), new TestOutputWriter());
        TestLibraryRepository testLibraryRepository = new TestLibraryRepository();
        testLibraryRepository.checkoutBook(titleOfBook, null);
        ReturnBookMenuOption returnBookMenuOption =
                new ReturnBookMenuOption(inputOutputHandler, testLibraryRepository);
        String successfulReturnMessage = "\nThank you for returning the book.\n";
        ConsoleOutput expectedOutput = new ConsoleOutput(successfulReturnMessage);

        ConsoleOutput output = returnBookMenuOption.action();

        assertEquals(expectedOutput, output);
    }

    @Test
    public void shouldInformUserAfterAnUnsuccessfulReturn(){
        String titleOfBook = "game of thrones";
        InputOutputHandler inputOutputHandler =
                new InputOutputHandler(new TestInputReader(titleOfBook), new TestOutputWriter());
        TestLibraryRepository testLibraryRepository = new TestLibraryRepository();
        testLibraryRepository.checkoutBook(titleOfBook, null);
        ReturnBookMenuOption returnBookMenuOption =
                new ReturnBookMenuOption(inputOutputHandler, testLibraryRepository);
        String unsuccessfulReturnMessage = "\nThat is not a valid book to return.\n";
        ConsoleOutput expectedOutput = new ConsoleOutput(unsuccessfulReturnMessage);

        ConsoleOutput output = returnBookMenuOption.action();

        assertEquals(expectedOutput, output);
    }
}
