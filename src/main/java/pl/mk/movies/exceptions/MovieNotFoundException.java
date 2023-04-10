package pl.mk.movies.exceptions;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(String id) {
        super("Nie znaleziono filmu o id " + id);
    }
}
