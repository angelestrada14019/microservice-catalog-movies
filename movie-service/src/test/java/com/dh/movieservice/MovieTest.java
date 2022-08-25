package com.dh.movieservice;

import com.dh.movieservice.domain.model.Movie;
import com.dh.movieservice.domain.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MovieTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    @Rollback(value = false)
    @Order(1)
    public void testSaveMovie(){
        Movie movie = new Movie("movieName","action","urlStreamTest");
        Movie movieSave = movieRepository.save(movie);
        Assertions.assertNotNull(movieSave);
    }
    @Test
    @Order(2)
    public void testFindMovieByGenre(){
//        Movie movieSave = new Movie("movieName","action","urlStreamTest");
//        movieRepository.save(movieSave);
        List<Movie> movies = movieRepository.findByGenre("action");
        for (Movie movie : movies) {
            log.info(movie.toString());
        }
        Assertions.assertTrue(movies.size()>0);
    }
}
