package com.twu.model.repository;

import com.twu.biblioteca.Status;
import com.twu.model.artifacts.*;
import com.twu.model.sorter.MovieSorter;

import java.util.*;

import static com.twu.biblioteca.Status.AVAILABLE;
import static com.twu.biblioteca.Status.CHECKED_OUT;

public class MovieRepository implements Repository{

    private Map<Movie, Status> movieToStatusMap;

    public MovieRepository(){
        movieToStatusMap = new HashMap<>();
        movieToStatusMap.put(new Movie("The Sixth Sense", "1999", "M. Night Shyamalan", "8.1"), AVAILABLE);
        movieToStatusMap.put(new Movie("Love Actually", "2003", "Richard Curtis", null), AVAILABLE);

        movieToStatusMap.put(new Movie("When Harry Met Sally", "1989", "Rob Reiner", "7.6"), AVAILABLE);

        movieToStatusMap.put(new Movie("Pretty Woman", "1990", "Garry Marshall", "6.9"), AVAILABLE);
        movieToStatusMap.put(new Movie("Sleepless in Seattle", "1993", "Nora Ephron", "6.8"), AVAILABLE);
        movieToStatusMap.put(new Movie("Notting Hill", "1999", "Roger Michell", "7.0"), AVAILABLE);
    }
    
    @Override
    public List<Artifact> getAvailableArtifacts() {
        List<Artifact> availableMovies = new ArrayList<>();
        for (Map.Entry movieEntry : movieToStatusMap.entrySet()) {
            if (movieEntry.getValue() == AVAILABLE)
                availableMovies.add((Movie) movieEntry.getKey());
        }
        Collections.sort(availableMovies, new MovieSorter());
        return availableMovies;
    }

    @Override
    public boolean checkoutArtifact(String title) {
        Movie movieToBeCheckedOut = findMovie(title);
        if( movieToBeCheckedOut == null) {
            return false;
        }
        movieToStatusMap.replace(movieToBeCheckedOut, CHECKED_OUT);
        return true;
    }

    private Movie findMovie(String titleOfMovie) {
        for(Map.Entry movieEntry : movieToStatusMap.entrySet()) {
            Movie movie = (Movie)movieEntry.getKey();
            if (movie.getTitle().equalsIgnoreCase(titleOfMovie)) {
                return movie;
            }
        }
        return null;
    }
    
    @Override
    public boolean returnArtifact(String title) {
        return false;
    }
}
