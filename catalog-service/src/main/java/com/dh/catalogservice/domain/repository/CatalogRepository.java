package com.dh.catalogservice.domain.repository;

import com.dh.catalogservice.domain.model.Catalog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends MongoRepository<Catalog,String> {
    @Query("{ genre : ?0 }")
    Catalog findByGenre(String genre);
}
