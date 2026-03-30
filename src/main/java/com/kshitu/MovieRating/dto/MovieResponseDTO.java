package com.kshitu.MovieRating.dto;

import java.util.Date;

public record MovieResponseDTO(
        Long id,
        String name,
        float duration,
        String director,
        Date release
) {}
