package com.kshitu.MovieRating.repository;

import com.kshitu.MovieRating.model.review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<review, Long> {

    List<review> findByMovieId(Long id);
}
