package com.twu.menoption;

import com.twu.io.output.ConsoleOutput;
import com.twu.mockmodels.TestLibraryRepository;
import com.twu.model.artifacts.Movie;
import com.twu.model.menuoption.ListCheckedOutMoviesMenuOption;
import com.twu.model.user.Customer;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ListCheckedOutMoviesMenuOptionTest {
    @Test
    public void shouldListCheckedOutMovies() {
        Customer customer = new Customer("Test", "CUS-TEST", "test@gmail.com", "98", "test");
        TestLibraryRepository libraryRepository = new TestLibraryRepository();
        Movie movie = libraryRepository.checkoutMovie("when harry met sally", customer);
        ListCheckedOutMoviesMenuOption listCheckedOutMoviesMenuOption =
                new ListCheckedOutMoviesMenuOption(libraryRepository);
        ConsoleOutput expectedOutput = getCheckedOutMoviesDetails(movie, customer);

        ConsoleOutput output = listCheckedOutMoviesMenuOption.action();

        assertEquals(expectedOutput, output);
    }

    public ConsoleOutput getCheckedOutMoviesDetails(Movie movie, Customer customer) {
        ArrayList<String> movieDetails = new ArrayList<>();
        movieDetails.add(String.format("Checked Out Movies are :-\n\n%-20s %-20s %-20s", "Title", "User Name", "Library Number"));
        movieDetails.add(String.format("%-20s %-20s %-20s", movie.getTitle(), customer.getName(), customer.getLibraryNumber()));
        return new ConsoleOutput(movieDetails);
    }

    @Test
    public void shouldReturnNoCheckedOutMoviesMessageWhenThereAreNoCheckedOutMovies() {
        TestLibraryRepository libraryRepository = new TestLibraryRepository();
        ListCheckedOutMoviesMenuOption listCheckedOutMoviesMenuOption =
                new ListCheckedOutMoviesMenuOption(libraryRepository);
        ConsoleOutput expectedOutput = new ConsoleOutput("\nThere are no checked out movies.");

        ConsoleOutput output = listCheckedOutMoviesMenuOption.action();

        assertEquals(expectedOutput, output);
    }
}
