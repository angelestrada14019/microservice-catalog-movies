package com.dh.catalogservice.api.queue;

import com.dh.catalogservice.api.service.MovieService;
import com.dh.catalogservice.api.service.SerieService;
import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.Serie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MovieListener {
    private final MovieService service;


    public MovieListener(MovieService service) {
        this.service = service;
    }

    @RabbitListener(queues = {"${queue.movie.name}"})
    public void receiveMovie(@Payload Movie movie){
        var r = service.save(movie);
        log.info(r.toString());
    }
}
