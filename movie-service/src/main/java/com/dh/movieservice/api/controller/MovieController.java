package com.dh.movieservice.api.controller;

import com.dh.movieservice.api.service.MovieService;
import com.dh.movieservice.domain.model.Movie;
import com.dh.movieservice.utils.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping("/{genre}")
    ResponseEntity<WrapperResponse<List<Movie>>> getMovieByGenre(@PathVariable String genre) {
        List<Movie> movies=service.findByGenre(genre);
        if (movies.isEmpty()){
            return new WrapperResponse<>(true,"No hay contenido",movies).createResponse(HttpStatus.OK);
        }
        return new WrapperResponse<>(true,"Succes",movies).createResponse(HttpStatus.OK);
    }

    @PostMapping("/save")
    ResponseEntity<WrapperResponse<Movie>> saveMovie(@RequestBody Movie movie) {
        return new WrapperResponse<>(true, "Succes", service.save(movie)).createResponse(HttpStatus.OK);
    }
}
