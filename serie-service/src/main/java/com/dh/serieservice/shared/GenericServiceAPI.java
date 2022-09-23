package com.dh.serieservice.shared;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;
import java.util.List;

public interface GenericServiceAPI<T,ID extends Serializable> {

    T save(T entity);
    void delete(ID id);
    T getOne(ID id);
    List<T> getAll();
    MongoRepository<T,ID> getRepository(); //tener repositorio de este tipo
}
