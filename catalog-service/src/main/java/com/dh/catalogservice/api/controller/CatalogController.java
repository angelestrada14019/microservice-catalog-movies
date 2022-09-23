package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.domain.model.Catalog;
import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.Serie;
import com.dh.catalogservice.utils.WrapperResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService service;

    public CatalogController(CatalogService service) {
        this.service = service;
    }


    @GetMapping("/{genre}")
    @Retry(name = "allCB")
    @CircuitBreaker(name = "allCB", fallbackMethod = "fallBackSaveAll")
    ResponseEntity<WrapperResponse<Catalog>> getGenre(@PathVariable String genre) {
        return new WrapperResponse<>(true, "Succes",
                service.findCatalogByGenre(genre)).createResponse(HttpStatus.OK);
    }
    private ResponseEntity<WrapperResponse<Catalog>> fallBackGetAll(@PathVariable String genre,RuntimeException e){
        Catalog catalog = new Catalog();
        return new WrapperResponse<>(false, "En estos momentos no " +
                "se puede traer el catalogo con las peliculas y series, intentelo mas tarde",catalog)
                .createResponse(HttpStatus.PARTIAL_CONTENT);
    }
    @PostMapping("/save")
    ResponseEntity<WrapperResponse<Catalog>> save(@RequestBody Catalog catalog) {
        return new WrapperResponse<>(true, "Succes",
                service.save(catalog)).createResponse(HttpStatus.OK);
    }


    @PostMapping("/save_movie")
    @Retry(name = "movieCB")
    @CircuitBreaker(name = "movieCB", fallbackMethod = "fallBackSaveMovie")
    ResponseEntity<WrapperResponse<Movie>> saveMovie(@RequestBody Movie movie) {
        return new WrapperResponse<>(true, "Succes",
                service.saveMovie(movie)).createResponse(HttpStatus.OK);
    }
    private ResponseEntity<WrapperResponse<Movie>> fallBackSaveMovie(@RequestBody Movie movie,RuntimeException e){
        return new WrapperResponse<>(false, "En estos momentos no " +
                "se pueden guardar peliculas, intentelo mas tarde",movie)
                .createResponse(HttpStatus.PARTIAL_CONTENT);
    }
    @PostMapping("/save_serie")
    @Retry(name = "serieCB")
    @CircuitBreaker(name = "serieCB", fallbackMethod = "fallBackSaveSerie")
    ResponseEntity<WrapperResponse<Serie>> saveSerie(@RequestBody Serie serie) {
        return new WrapperResponse<>(true, "Succes",
                service.saveSerie(serie)).createResponse(HttpStatus.OK);
    }
    private ResponseEntity<WrapperResponse<Serie>> fallBackSaveSerie(@RequestBody Serie serie,RuntimeException e){
        return new WrapperResponse<>(false, "En estos momentos no " +
                "se pueden guardar series, intentelo mas tarde",serie)
                .createResponse(HttpStatus.PARTIAL_CONTENT);
    }




}
