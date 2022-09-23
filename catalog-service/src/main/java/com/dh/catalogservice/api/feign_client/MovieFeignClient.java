package com.dh.catalogservice.api.feign_client;

import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.Serie;
import com.dh.catalogservice.utils.WrapperResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;



@FeignClient(name = "movie-service")
public interface MovieFeignClient {
    @GetMapping("/movie/{genre}")
    List<Movie> getMovies(@PathVariable String genre);

    @PostMapping("/movie/save")
    Movie saveMovie(@RequestBody Movie movie);
}
