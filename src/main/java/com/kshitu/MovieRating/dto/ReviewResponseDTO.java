package com.kshitu.MovieRating.dto;



public record ReviewResponseDTO(
        Long id,
        String movie_name,
        String user_name,
        int rating,
        String content
) {}
