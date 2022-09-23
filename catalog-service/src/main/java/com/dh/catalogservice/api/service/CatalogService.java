package com.dh.catalogservice.api.service;
import com.dh.catalogservice.api.feign_client.MovieFeignClient;
import com.dh.catalogservice.api.feign_client.SerieFeignClient;
import com.dh.catalogservice.domain.model.Catalog;
import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.Serie;
import com.dh.catalogservice.domain.repository.CatalogRepository;
import com.dh.catalogservice.exceptions.GeneralServicesExceptions;
import com.dh.catalogservice.exceptions.NoDataFoundExceptions;
import com.dh.catalogservice.exceptions.ValidateServiceExceptions;
import com.dh.catalogservice.shared.GenericServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j

public class CatalogService extends GenericServiceImpl<Catalog,String>
        implements ICatalogService {

    private final CatalogRepository catalogRepository;
    private final MovieService movieService;
    private final SerieService serieService;

    private final SerieFeignClient serieFeignClient;
    private final MovieFeignClient movieFeignClient;

    public CatalogService(CatalogRepository catalogRepository, MovieService movieService, SerieService serieService, SerieFeignClient serieFeignClient, MovieFeignClient movieFeignClient) {
        this.catalogRepository = catalogRepository;
        this.movieService = movieService;
        this.serieService = serieService;
        this.serieFeignClient = serieFeignClient;
        this.movieFeignClient = movieFeignClient;
    }

    @Override
    public Catalog findCatalogByGenre(String genre){
        try {
            Catalog catalog = catalogRepository.findByGenre(genre);
            if (catalog == null) throw new NoDataFoundExceptions("No existe el genero: "+genre);
            List<Movie> movies =  movieService.getByGenre(genre);
            if (movies.isEmpty()) movies = new ArrayList<>();
            List<Serie> series =  serieService.getByGenre(genre);
            if (series.isEmpty()) series = new ArrayList<>();
            movies.forEach(catalog::addMovie);
            series.forEach(catalog::addSerie);
            return catalog;
        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.error(e.getMessage());
            throw e;
        }catch (Exception e){
            throw new GeneralServicesExceptions(e.getMessage());
        }

    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieFeignClient.saveMovie(movie);
    }

    @Override
    public Serie saveSerie(Serie serie) {
        return serieFeignClient.saveSeries(serie);
    }

    @Override
    public MongoRepository<Catalog, String> getRepository() {
        return catalogRepository;
    }
}
