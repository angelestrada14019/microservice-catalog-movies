package com.dh.catalogservice.api.service;

import com.dh.catalogservice.domain.model.Catalog;
import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.Serie;
import com.dh.catalogservice.shared.GenericServiceAPI;
import com.dh.catalogservice.utils.WrapperResponse;

import java.util.List;

public interface ICatalogService extends GenericServiceAPI<Catalog,String> {

    Catalog findCatalogByGenre(String genre);
    Movie saveMovie(Movie movie);
    Serie saveSerie(Serie serie);
}
