package com.kshitu.MovieRating.dto;


import java.util.Date;

public record MovieRequestDTO(
        String name,
        float duration,
        String director,
        Date releaseDate
) {}
