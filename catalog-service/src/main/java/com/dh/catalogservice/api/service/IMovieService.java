package com.dh.catalogservice.api.service;

import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.Serie;
import com.dh.catalogservice.shared.GenericServiceAPI;

import java.util.List;

public interface IMovieService extends GenericServiceAPI<Movie,String> {
    List<Movie> getByGenre(String genre);
}
