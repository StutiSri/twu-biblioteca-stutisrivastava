package com.twu.menoption;

import com.twu.io.output.ConsoleOutput;
import com.twu.mockmodels.TestLibraryRepository;
import com.twu.model.menuoption.ListBooksMenuOption;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListBooksMenuOptionTest {

    @Test
    public void detailsInBookListingShouldBeFormattedAsColumns() {
        ConsoleOutput expectedBookListingOutput = new ConsoleOutput
                (new TestLibraryRepository().getBookListing());

        ConsoleOutput bookListOutput = new ListBooksMenuOption(new TestLibraryRepository()).action();

        assertEquals(expectedBookListingOutput, bookListOutput);
    }

}

