package com.twu.menoption;

import com.twu.io.output.ConsoleOutput;
import com.twu.mockmodels.TestLibraryRepository;
import com.twu.model.menuoption.ListMoviesMenuOption;
import com.twu.model.repository.LibraryRepository;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListMoviesMenuOptionTest {
    @Test
    public void shouldReturnListOfMovies(){
        ConsoleOutput expectedBookListingOutput = new ConsoleOutput
                (new TestLibraryRepository().getMovieListing());

        ConsoleOutput bookListOutput = new ListMoviesMenuOption(new LibraryRepository()).action();

        assertEquals(expectedBookListingOutput, bookListOutput);
    }
}
