package com.dh.catalogservice.api.service;

import com.dh.catalogservice.domain.model.Serie;
import com.dh.catalogservice.shared.GenericServiceAPI;

import java.util.List;

public interface ISerieService extends GenericServiceAPI<Serie,String> {
    List<Serie> getByGenre(String genre);
}
