package com.dh.serieservice.api.controller;

import com.dh.serieservice.api.service.SerieService;
import com.dh.serieservice.domain.model.Serie;
import com.dh.serieservice.shared.GenericRestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("serie")
public class SerieController extends GenericRestController<Serie,String> {

    private final SerieService serieService;

    protected SerieController(SerieService serviceAPI) {
        super(serviceAPI);
        this.serieService = serviceAPI;
    }
}
