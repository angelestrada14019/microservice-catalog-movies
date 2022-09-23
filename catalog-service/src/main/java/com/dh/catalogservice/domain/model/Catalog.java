package com.dh.catalogservice.domain.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Document("catalog")
public class Catalog {

    @Id
    private String id;
    private String genre;

    @Transient
    private List<Movie> movies;
    @Transient
    private List<Serie> series;

    public Catalog() {
        this.movies = new ArrayList<>();
        this.series = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }

    public void addSerie(Serie serie) {
        this.series.add(serie);
    }
}
