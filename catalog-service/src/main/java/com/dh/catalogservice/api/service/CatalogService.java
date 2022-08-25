package com.dh.catalogservice.api.service;
import com.dh.catalogservice.api.feign_client.MovieFeignClient;
import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.exceptions.GeneralServicesExceptions;
import com.dh.catalogservice.exceptions.NoDataFoundExceptions;
import com.dh.catalogservice.exceptions.ValidateServiceExceptions;
import com.dh.catalogservice.utils.WrapperResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class CatalogService implements ICatalogService {

    @Autowired
    private MovieFeignClient movieFeignClient;



    @Override
    public WrapperResponse<List<Movie>> getMovieByGenre(String genre) {
        try {
        WrapperResponse<List<Movie>> movies = movieFeignClient.getMovies(genre);
        return movies;

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }
    }


}
