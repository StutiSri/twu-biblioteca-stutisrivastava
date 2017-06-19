package com.twu.model.menuoption;

import com.twu.io.output.ConsoleOutput;
import com.twu.model.artifacts.Artifact;
import com.twu.model.artifacts.Movie;
import com.twu.model.repository.LibraryRepository;

import java.util.ArrayList;
import java.util.List;

public class ListMoviesMenuOption implements MenuOption{
    private LibraryRepository repository;
    private final String MENU_OPTION_NAME = "List Movies";

    public ListMoviesMenuOption(LibraryRepository libraryRepository) {
        repository = libraryRepository;
    }

    private void addColumnNames(List<String> movieListing) {
        String column = String.format("%-30s%-17s%-30s%-7s", "Title","Year of Release",
                "Director", "Rating\n");
        movieListing.add(column);
    }

    @Override
    public ConsoleOutput action() {
        List<Movie> allMovies = repository.getAvailableMovies();
        List<String> movieListing = new ArrayList<>();
        movieListing.add("\nAvailable Movies :-\n");
        addColumnNames(movieListing);
        for(Artifact movie : allMovies)
            movieListing.add(movie.toString());
        movieListing.add("--------------------------------------------------\n");
        return new ConsoleOutput(movieListing);
    }

    @Override
    public String getMenuOptionName() {
        return MENU_OPTION_NAME;
    }
}
