package com.dh.catalogservice.api.service;
import com.dh.catalogservice.api.feign_client.MovieFeignClient;
import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.dto.CatalogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatalogService implements ICatalogService {

    @Autowired
    private MovieFeignClient movieFeignClient;



    @Override
    public List<Movie> getMovieByGenre(String genre) {
        List<Movie> movies = movieFeignClient.getMovies(genre);
        return movies;
    }


}
