package com.dh.movieservice.shared;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public abstract class GenericServiceImpl<T,ID extends Serializable> implements GenericServiceAPI<T,ID> {

    @Override
    public T save(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public void delete(ID id) {
        getRepository().deleteById(id);
    }

    @Override
    public T getOne(ID id) {
        Optional<T> optionalT = getRepository().findById(id);
        return optionalT.orElse(null);
    }

    @Override
    public List<T> getAll() {
        return getRepository().findAll();
    }

    @Override
    public  abstract JpaRepository<T, ID> getRepository();
}
