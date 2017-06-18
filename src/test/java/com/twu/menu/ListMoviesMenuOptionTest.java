package com.twu.menu;

import com.twu.io.output.ConsoleOutput;
import com.twu.mockmodels.TestMovieRepository;
import com.twu.model.menuoption.ListMoviesMenuOption;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListMoviesMenuOptionTest {
    @Test
    public void shouldReturnListOfMovies(){
        ConsoleOutput expectedBookListingOutput = new ConsoleOutput
                (new TestMovieRepository().getMovieListing());

        ConsoleOutput bookListOutput = new ListMoviesMenuOption(new TestMovieRepository()).action();

        assertEquals(expectedBookListingOutput, bookListOutput);
    }
}
