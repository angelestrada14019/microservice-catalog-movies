package com.dh.catalogservice.api.service;

import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.repository.MovieRepository;
import com.dh.catalogservice.shared.GenericServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService extends GenericServiceImpl<Movie,String>
        implements IMovieService{

    private final MovieRepository movieRepository;

    @Override
    public List<Movie> getByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }
    @Override
    public MongoRepository<Movie, String> getRepository() {
        return movieRepository;
    }


}
