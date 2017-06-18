package com.twu.biblioteca;

import com.twu.mockmodels.TestMovieRepository;
import com.twu.model.artifacts.Artifact;
import com.twu.model.repository.MovieRepository;
import com.twu.model.repository.MovieRepository;
import com.twu.model.repository.Repository;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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

    @Test
    public void shouldCheckoutAnAvailableMovie(){
        Repository repository = new MovieRepository();
        String movieToBeCheckedOut = "notting hill";
        assertTrue(repository.checkoutArtifact(movieToBeCheckedOut));
    }

    @Test
    public void shouldNotCheckoutAnUnavailableMovie(){
        Repository repository = new MovieRepository();
        String movieToBeCheckedOut = "harry potter";
        assertFalse(repository.checkoutArtifact(movieToBeCheckedOut));
    }
    
}
