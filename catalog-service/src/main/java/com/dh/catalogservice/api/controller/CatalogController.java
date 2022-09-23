package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.domain.model.Catalog;
import com.dh.catalogservice.utils.WrapperResponse;
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
    ResponseEntity<WrapperResponse<Catalog>> getGenre(@PathVariable String genre) {
        return new WrapperResponse<>(true, "Succes",
                service.findCatalogByGenre(genre)).createResponse(HttpStatus.OK);
    }




}
