package com.kshitu.MovieRating.controller;

import com.kshitu.MovieRating.dto.MovieRequestDTO;
import com.kshitu.MovieRating.dto.MovieResponseDTO;
import com.kshitu.MovieRating.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    MovieService service;

    @GetMapping
    public List<MovieResponseDTO> getallmovies()
    {
        return service.getAllMovies();
    }

    @GetMapping("/{movie_id}")
    public MovieResponseDTO getById(@PathVariable("movie_id") Long id)
    {
        return service.getById(id);
    }

    @PostMapping
    public void load(@RequestBody MovieRequestDTO movie)
    {
       service.load(movie);
    }

    @PutMapping("/{movie_id}")
    public MovieResponseDTO updateMovie(@PathVariable("movie_id") Long movie_id, @RequestBody MovieRequestDTO m)
    {
        return service.updateMovie(movie_id, m);
    }

    @DeleteMapping("/{movie_id}")
    public MovieResponseDTO deleteById(@PathVariable("movie_id") Long id)
    {
        return service.deleteById(id);
    }

}
