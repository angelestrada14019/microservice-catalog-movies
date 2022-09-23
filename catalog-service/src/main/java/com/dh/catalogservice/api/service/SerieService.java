package com.dh.catalogservice.api.service;
import com.dh.catalogservice.domain.model.Serie;
import com.dh.catalogservice.domain.repository.SerieRepository;
import com.dh.catalogservice.shared.GenericServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SerieService extends GenericServiceImpl<Serie,String>
        implements ISerieService{
    private final SerieRepository serieRepository;

    @Override
    public List<Serie> getByGenre(String genre) {
        return serieRepository.findByGenre(genre);
    }
    @Override
    public MongoRepository<Serie, String> getRepository() {
        return serieRepository;
    }

}
