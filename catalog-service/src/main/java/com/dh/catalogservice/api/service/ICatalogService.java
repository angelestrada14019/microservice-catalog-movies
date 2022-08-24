package com.dh.catalogservice.api.service;

import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.dto.CatalogDto;

import java.util.List;

public interface ICatalogService {
    CatalogDto getMovieByGenre (String genre);
}
