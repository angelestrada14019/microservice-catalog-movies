package com.dh.movieservice.api.service;

import com.dh.movieservice.domain.model.Movie;
import com.dh.movieservice.shared.GenericServiceAPI;

import java.util.List;

public interface IMovieService extends GenericServiceAPI<Movie,Long> {
    List<Movie> findByGenre(String genre);
}
