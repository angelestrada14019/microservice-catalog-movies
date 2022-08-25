package com.dh.catalogservice.api.service;

import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.dto.CatalogDto;
import com.dh.catalogservice.utils.WrapperResponse;

import java.util.List;

public interface ICatalogService {
    WrapperResponse<List<Movie>> getMovieByGenre (String genre);
}
