package com.dh.catalogservice.api.service;
import com.dh.catalogservice.domain.model.Catalog;
import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.Serie;
import com.dh.catalogservice.domain.repository.CatalogRepository;
import com.dh.catalogservice.shared.GenericServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j

public class CatalogService extends GenericServiceImpl<Catalog,String>
        implements ICatalogService {

    private final CatalogRepository catalogRepository;
    private final MovieService movieService;
    private final SerieService serieService;

    public CatalogService(CatalogRepository catalogRepository, MovieService movieService, SerieService serieService) {
        this.catalogRepository = catalogRepository;
        this.movieService = movieService;
        this.serieService = serieService;
    }

    @Override
    public Catalog findCatalogByGenre(String genre){
        Catalog catalog = catalogRepository.findByGenre(genre);
        List<Movie> movies =  movieService.getByGenre(genre);
        List<Serie> series =  serieService.getByGenre(genre);
        assert catalog != null;
        movies.forEach(catalog::addMovie);
        series.forEach(catalog::addSerie);
        return catalog;
    }

    @Override
    public MongoRepository<Catalog, String> getRepository() {
        return catalogRepository;
    }
}
