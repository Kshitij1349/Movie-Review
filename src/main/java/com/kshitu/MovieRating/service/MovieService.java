package com.kshitu.MovieRating.service;

import com.kshitu.MovieRating.repository.MovieRepo;
import com.kshitu.MovieRating.dto.MovieRequestDTO;
import com.kshitu.MovieRating.dto.MovieResponseDTO;
import com.kshitu.MovieRating.model.movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    
    @Autowired
    MovieRepo repo;

    
    public List<MovieResponseDTO> getAllMovies() {

        List<MovieResponseDTO> responseDTOS=new ArrayList<>();

        for(movies m : repo.findAll())
        {
            MovieResponseDTO dto=new MovieResponseDTO(
                    m.getId(),
                    m.getName(),
                    m.getDuration(),
                    m.getDirector(),
                    m.getRelease_date()
            );
            responseDTOS.add(dto);
        }

        return responseDTOS;
    }

    public MovieResponseDTO getById(Long id) {
        movies m= repo.findById(id).orElse(new movies());
        MovieResponseDTO DTO=new MovieResponseDTO(
                m.getId(),
                m.getName(),
                m.getDuration(),
                m.getDirector(),
                m.getRelease_date()
        );

        return DTO;
    }

    public void load(MovieRequestDTO m) {
        movies movie=new movies();
        movie.setName(m.name());
        movie.setDirector(m.director());
        movie.setDuration(m.duration());
        movie.setRelease_date(m.releaseDate());
        repo.save(movie);
    }

    public MovieResponseDTO updateMovie(Long movieId, MovieRequestDTO m) {
        movies movie=repo.findById(movieId).orElse(new movies());

        movie.setName(m.name());
        movie.setDirector(m.director());
        movie.setRelease_date(m.releaseDate());
        movie.setDuration(m.duration());

        movies save = repo.save(movie);

        MovieResponseDTO DTO=new MovieResponseDTO(
                movie.getId(),
                movie.getName(),
                movie.getDuration(),
                movie.getDirector(),
                movie.getRelease_date()
        );

        return DTO;

    }

    public MovieResponseDTO deleteById(Long id) {
        movies movie=repo.findById(id).orElse(new movies());

        MovieResponseDTO DTO=new MovieResponseDTO(
                movie.getId(),
                movie.getName(),
                movie.getDuration(),
                movie.getDirector(),
                movie.getRelease_date()
        );

        repo.deleteById(id);

        return DTO;
    }
}
