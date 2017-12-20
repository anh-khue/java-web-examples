package com.khuetla.spring.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Anh Khue
 */

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository repository;

    @Autowired
    public MovieController(MovieRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String getAllMovies(Model model) {
        List<Movie> movies = repository.findAll();
        model.addAttribute("movies", movies);
        return "all_movies";
    }

    @GetMapping("{id}")
    public String getMovieById(@PathVariable("id") String id, Model model) {
        Movie movie = repository.findById(Integer.parseInt(id));
        model.addAttribute("movie", movie);
        return "movie";
    }

    @GetMapping("add")
    public String goToAddMoviePage(Model model) {
        model.addAttribute("movie", new Movie());
        return "add_movie";
    }

    @PostMapping
    public String addNewMovie(@ModelAttribute Movie movie, Model model) {
        repository.save(movie);
        return getAllMovies(model);
    }
}
