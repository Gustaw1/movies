package pl.mk.movies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mk.movies.models.Movie;
import pl.mk.movies.services.MovieService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        List<Movie> movieList = movieService.allMovies();

        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Optional> getMovie(@PathVariable ObjectId id) {
//        Optional<Movie> movie = movieService.getById(id);
//        return new ResponseEntity<Optional>(movie, HttpStatus.OK);
//    }

    @GetMapping("/{filmwebId}")
    public ResponseEntity<Optional> getMovieByFilmwebId(@PathVariable String filmwebId) {
        Optional<Movie> movie = movieService.findByFilmwebId((filmwebId));
        return new ResponseEntity<Optional>(movie, HttpStatus.OK);
    }

}
