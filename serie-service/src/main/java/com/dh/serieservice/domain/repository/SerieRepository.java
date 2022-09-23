package com.dh.serieservice.domain.repository;

import com.dh.serieservice.domain.model.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerieRepository extends MongoRepository<Serie, String> {
}
