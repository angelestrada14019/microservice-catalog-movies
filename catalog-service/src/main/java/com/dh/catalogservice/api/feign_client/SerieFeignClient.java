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

@FeignClient(name = "serie-service", url = "http://localhost:8083")
public interface SerieFeignClient {

    @GetMapping("/serie/{genre}")
    List<Serie> getSeries(@PathVariable String genre);

    @PostMapping("/serie/save")
    Serie saveSeries(@RequestBody Serie serie);
}
