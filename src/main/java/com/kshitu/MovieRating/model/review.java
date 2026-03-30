package com.kshitu.MovieRating.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private user reviewer_name;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private movies movie;
    private int rating;
    private String content;
}
