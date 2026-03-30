package com.kshitu.MovieRating.dto;

import com.kshitu.MovieRating.model.movies;

public record ReviewRequestDTO(
        Long user_id,
        Long movie_id,
        int rating,
        String content
) {}
