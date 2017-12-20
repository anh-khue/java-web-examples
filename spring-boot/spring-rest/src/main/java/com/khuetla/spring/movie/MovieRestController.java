package com.khuetla.spring.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Anh Khue
 */
@RestController
@RequestMapping("/movies")
public class MovieRestController {

    private final MovieRepository repository;

    @Autowired
    public MovieRestController(MovieRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return repository.findAll();
    }

    @GetMapping(value = "{id}")
    public Movie getMovieById(@PathVariable("id") String id) {
        return repository.findById(Integer.parseInt(id));
    }

    @PostMapping
    public ResponseEntity addNewMovie(@RequestBody Movie movie) {
        repository.save(movie);
        return new ResponseEntity(HttpStatus.OK);
    }
}
