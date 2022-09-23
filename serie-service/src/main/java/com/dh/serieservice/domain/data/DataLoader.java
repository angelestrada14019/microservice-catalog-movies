package com.dh.serieservice.domain.data;

import com.dh.serieservice.api.service.SerieService;
import com.dh.serieservice.domain.model.Chapter;
import com.dh.serieservice.domain.model.Season;
import com.dh.serieservice.domain.model.Serie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

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
        Season season1 = new Season();
        season1.setId("1");
        season1.setSeasonNumber(1);
        Chapter chapter1 = new Chapter();
        chapter1.setId("1");
        chapter1.setNumber(1);
        chapter1.setName("Chapter 1");
        chapter1.setUrlStream("http://urlchapter1.com");
        season1.setChapters(List.of(chapter1));
        serie1.setSeasons(List.of(season1));

        service.save(serie1);

        Serie serie2 = new Serie();
        serie2.setName("Serie 2");
        serie2.setGenre("terror");
        Season season2 = new Season();
        season2.setId("5");
        season2.setSeasonNumber(23);
        Chapter chapter2 = new Chapter();
        chapter2.setId("3");
        chapter2.setNumber(12);
        chapter2.setName("Chapter 2");
        chapter2.setUrlStream("http://urlchapter2.com");
        season2.setChapters(List.of(chapter2));
        serie2.setSeasons(List.of(season2));
        service.save(serie2);
    }
}
