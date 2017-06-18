package com.twu.model.menuoption;

import com.twu.io.output.ConsoleOutput;
import com.twu.model.artifacts.Artifact;
import com.twu.model.repository.MovieRepository;
import com.twu.model.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class ListMoviesMenuOption implements MenuOption{
    private Repository repository;

    public ListMoviesMenuOption(Repository movieRepository) {
        repository = movieRepository;
    }

    private void addColumnNames(List<String> movieListing) {
        String column = String.format("%-30s%-17s%-30s%-7s", "Title","Year of Release",
                "Director", "Rating\n");
        movieListing.add(column);
    }

    @Override
    public ConsoleOutput action() {
        List<Artifact> allMovies = repository.getAvailableArtifacts();
        List<String> movieListing = new ArrayList<>();
        movieListing.add("\nAvailable Movies :-\n");
        addColumnNames(movieListing);
        for(Artifact movie : allMovies)
            movieListing.add(movie.toString());
        movieListing.add("--------------------------------------------------\n");
        return new ConsoleOutput(movieListing);
    }
}
