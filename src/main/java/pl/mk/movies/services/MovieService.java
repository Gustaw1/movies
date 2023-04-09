package pl.mk.movies.services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mk.movies.models.Movie;
import pl.mk.movies.repos.MovieRepo;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepo movieRepo;

    public List<Movie> allMovies() {
        return movieRepo.findAll();
    }

    public Optional<Movie> getById(ObjectId id) {
        return movieRepo.findById(id);
    }

    public Optional<Movie> findByFilmwebId(String id) {
        return movieRepo.findByFilmwebId(id);
    }
}
