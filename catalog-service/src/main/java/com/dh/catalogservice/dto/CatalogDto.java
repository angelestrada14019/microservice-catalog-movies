package com.dh.catalogservice.dto;

import com.dh.catalogservice.domain.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogDto {
    private String genre;
    private List<Movie> movies;
}
