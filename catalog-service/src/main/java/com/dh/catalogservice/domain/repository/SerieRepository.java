package com.dh.catalogservice.domain.repository;
import com.dh.catalogservice.domain.model.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends MongoRepository<Serie,String> {
    @Query("{ genre : ?0 }")
    List<Serie> findByGenre(String genre);
}
