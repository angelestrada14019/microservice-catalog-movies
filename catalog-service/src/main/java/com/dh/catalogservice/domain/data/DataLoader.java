package com.dh.catalogservice.domain.data;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.domain.model.Catalog;
import com.dh.catalogservice.domain.repository.CatalogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataLoader implements ApplicationRunner {

    private final CatalogRepository catalogRepository;
    private final MongoTemplate mongoTemplate;

    public DataLoader(CatalogRepository catalogRepository, MongoTemplate mongoTemplate) {
        this.catalogRepository = catalogRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        mongoTemplate.dropCollection("serie");
        mongoTemplate.dropCollection("movie");
        mongoTemplate.dropCollection("catalog");
        Catalog catalog = new Catalog();
        catalog.setGenre("terror");
        catalogRepository.save(catalog);
    }
}
