package com.dh.serieservice.api.service;

import com.dh.serieservice.api.queue.SerieSender;
import com.dh.serieservice.domain.model.Serie;
import com.dh.serieservice.domain.repository.SerieRepository;
import com.dh.serieservice.shared.GenericServiceAPI;
import com.dh.serieservice.shared.GenericServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SerieService extends GenericServiceImpl<Serie,String> implements GenericServiceAPI<Serie,String> {
    private final SerieRepository repository;
    private final SerieSender sender;

    @Override
    public Serie save(Serie entity) {
        var serieDB = super.save(entity);
        sender.send(serieDB);
        return serieDB;
    }

    @Override
    public MongoRepository<Serie, String> getRepository() {
        return repository;
    }
}
