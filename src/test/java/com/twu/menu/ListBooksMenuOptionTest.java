package com.twu.menu;

import com.twu.biblioteca.BookRepository;
import com.twu.io.output.ConsoleOutput;
import com.twu.mockmodels.TestBookRepository;
import com.twu.model.menuoption.ListBooksMenuOption;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListBooksMenuOptionTest {

    @Test
    public void detailsInBookListingShouldBeFormattedAsColumns() {
        ConsoleOutput expectedBookListingOutput = new ConsoleOutput
                (new TestBookRepository().getBookListing());

        ConsoleOutput bookListOutput = new ListBooksMenuOption().action(new BookRepository());

        assertEquals(expectedBookListingOutput, bookListOutput);
    }

}

