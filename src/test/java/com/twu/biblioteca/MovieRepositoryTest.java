package com.twu.biblioteca;

import com.twu.mockmodels.TestMovieRepository;
import com.twu.model.artifacts.Artifact;
import com.twu.model.repository.MovieRepository;
import com.twu.model.repository.Repository;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MovieRepositoryTest {
    @Test
    public void shouldReturnListOfAvailableMovies() {
        String movieToBeCheckedOut = "when harry met sally";
        TestMovieRepository testMovieRepository = new TestMovieRepository();
        testMovieRepository.checkoutArtifact(movieToBeCheckedOut);
        List<Artifact> expectedMovies = testMovieRepository.getAvailableArtifacts();
        Repository repository = new MovieRepository();
        repository.checkoutArtifact(movieToBeCheckedOut);

        List<Artifact> movies = repository.getAvailableArtifacts();

        assertEquals(expectedMovies, movies);
    }
}
