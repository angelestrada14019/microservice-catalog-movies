package com.dh.catalogservice.api.feign_client;

import com.dh.catalogservice.domain.model.Movie;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@LoadBalancerClient(name = "movie-service",configuration = CustomLoadBalancerConfiguration.class)
@FeignClient(name = "movie-service")
public interface MovieFeignClient {
    @GetMapping("/movies/{genre}")
    List<Movie> getMovies(@PathVariable String genre);
}
