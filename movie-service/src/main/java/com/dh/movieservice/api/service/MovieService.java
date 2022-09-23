package com.dh.movieservice.api.service;

import com.dh.movieservice.api.queue.MovieSender;
import com.dh.movieservice.domain.model.Movie;
import com.dh.movieservice.domain.repository.MovieRepository;
import com.dh.movieservice.shared.GenericServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MovieService extends GenericServiceImpl<Movie,Long> implements IMovieService{

    private final MovieRepository repository;
    private final MovieSender sender;

//    public MovieService(MovieRepository repository) {
//        this.repository = repository;
//    }

    @Override
    public List<Movie> findByGenre(String genre) {
            List<Movie> movies= repository.findByGenre(genre);
            if (movies==null) return null;
            return movies;

    }
//    @Override
//    public Movie save(Movie movie) {
//        try {
//            return repository.save(movie);
//        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
//            log.info(e.getMessage(),e);
//            throw e;
//        }
//        catch (Exception e){
//            log.error(e.getMessage(),e);
//            throw new GeneralServicesExceptions(e.getMessage(),e);
//        }
//    }

    @Override
    public Movie save(Movie entity) {
        var movieDB = super.save(entity);
        sender.send(movieDB);
        return movieDB;
    }

    @Override
    public JpaRepository<Movie, Long> getRepository() {
        return repository;
    }
}
