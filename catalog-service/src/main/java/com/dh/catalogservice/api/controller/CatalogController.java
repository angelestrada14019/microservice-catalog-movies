package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.dto.CatalogDto;
import com.dh.catalogservice.utils.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService service;

    public CatalogController(CatalogService service) {
        this.service = service;
    }


    @GetMapping("/{genre}")
    ResponseEntity<WrapperResponse<CatalogDto>> getGenre(@PathVariable String genre) {
        WrapperResponse<List<Movie>> movies = service.getMovieByGenre(genre);
        return new WrapperResponse<>(movies.isOk(), movies.getMensaje(), new CatalogDto(genre,movies.getBody())).createResponse(HttpStatus.OK);
    }

}
