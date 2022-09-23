package com.dh.movieservice.domain.data;

import com.dh.movieservice.api.service.MovieService;
import com.dh.movieservice.domain.model.Movie;
import com.dh.movieservice.domain.repository.MovieRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final MovieService movieService;

    public DataLoader(MovieService mMovieService) {
        this.movieService = mMovieService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        movieService.save(new Movie(1L, "filme", "terror", "what"));
        movieService.save(new Movie(2L, "borboleta", "terror", "what"));
        movieService.save(new Movie(3L, "adedonha", "terror", "what"));
        movieService.save(new Movie(4L, "pajero", "terror", "what"));
        movieService.save(new Movie(5L, "dakar", "acao", "what"));
        movieService.save(new Movie(6L, "shadow", "acao", "what"));
        movieService.save(new Movie(7L, "boné", "romance", "what"));
        movieService.save(new Movie(8L, "xícara", "romance", "what"));
    }
}
