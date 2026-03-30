package com.kshitu.MovieRating.repository;

import com.kshitu.MovieRating.model.movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends JpaRepository<movies, Long> {
    movies findByName(String s);
}