package com.twu.mockmodels;

import com.twu.model.artifacts.*;
import com.twu.model.artifacts.Movie;
import com.twu.model.repository.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestMovieRepository implements Repository {
    private final List<Movie> movies;
    private final boolean isMovieCheckedOut;
    private Movie checkedOutMovie;

    public TestMovieRepository() {
        movies = new ArrayList<>();
        movies.add(new Movie("The Sixth Sense", "1999", "M. Night Shyamalan", "8.1"));
        movies.add(new Movie("Love Actually", "2003", "Richard Curtis", null));

        checkedOutMovie = new Movie("When Harry Met Sally", "1989", "Rob Reiner", "7.6");
        movies.add(checkedOutMovie);

        movies.add(new Movie("Pretty Woman", "1990", "Garry Marshall", "6.9"));
        movies.add(new Movie("Sleepless in Seattle", "1993", "Nora Ephron", "6.8"));
        movies.add(new Movie("Notting Hill", "1999", "Roger Michell", "7.0"));

        Collections.sort(movies, new MovieSorter());
        isMovieCheckedOut = false;
    }

    public List<String> getMovieListing() {
        List<String> movieListing = new ArrayList<>();

        movieListing.add("\nAvailable Movies :-\n");
        addColumnNames(movieListing);

        for (Movie movie : movies) {
            addMovieInColumnRepresentation(movieListing, movie);
        }

        movieListing.add("--------------------------------------------------\n");

        return movieListing;
    }

    @Override
    public List<Artifact> getAvailableArtifacts() {
        List<Artifact> availableMovies = new ArrayList<>();
        for(Movie movie : movies) {
            if(!(movie.equals(checkedOutMovie) && isMovieCheckedOut))
                availableMovies.add(movie);
        }
        return availableMovies;
    }

    @Override
    public boolean checkoutArtifact(String title) {
        return false;
    }

    @Override
    public boolean returnArtifact(String title) {
        return false;
    }

    private void addColumnNames(List<String> movieListing) {
        String columns = String.format("%-30s%-17s%-30s%-6s\n",
                "Title", "Year of Release", "Director", "Rating");
        movieListing.add(columns);
    }

    private void addMovieInColumnRepresentation(List<String> movieListRepresentation, Movie movie) {
        String rating = movie.getRating();
        if(movie.getRating() == null)
            rating = "Unrated";
        String movieRepresentation = String.format("%-30s%-17s%-30s%-7s",
                movie.getTitle(), movie.getYearOfRelease(), movie.getDirector(), rating);
        movieListRepresentation.add(movieRepresentation);
    }
}
