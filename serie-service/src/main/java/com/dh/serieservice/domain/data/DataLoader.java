package com.dh.serieservice.domain.data;

import com.dh.serieservice.api.service.SerieService;
import com.dh.serieservice.domain.model.Serie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataLoader implements ApplicationRunner {

    private final SerieService service;
    private final MongoTemplate mongoTemplate;

    public DataLoader(SerieService service, MongoTemplate mongoTemplate) {
        this.service = service;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        mongoTemplate.dropCollection("serie");
        Serie serie1 = new Serie();
        serie1.setName("Serie 1");
        serie1.setGenre("terror");
        service.save(serie1);
        Serie serie2 = new Serie();
        serie2.setName("Serie 2");
        serie2.setGenre("terror");
        service.save(serie2);
    }
}
