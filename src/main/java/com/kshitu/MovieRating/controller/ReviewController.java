package com.kshitu.MovieRating.controller;

import com.kshitu.MovieRating.dto.ReviewRequestDTO;
import com.kshitu.MovieRating.dto.ReviewResponseDTO;
import com.kshitu.MovieRating.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    ReviewService service;

    @PostMapping("")
    public ReviewResponseDTO addReview(@RequestBody ReviewRequestDTO json)
    {
       return service.addReview(json);
    }

    @GetMapping("")
    public List<ReviewResponseDTO> getAllReview()
    {
        return service.getAllReview();
    }

    @PutMapping("/{review_id}")
    public ReviewResponseDTO updateReview(@PathVariable("review_id") Long id, @RequestBody ReviewRequestDTO json)
    {
        return service.updateReview(id, json);
    }

    @DeleteMapping("/{review_id}")
    public ReviewResponseDTO deleteReview(@PathVariable("review_id") Long id)
    {
        return service.deleteReview(id);
    }

    @GetMapping("/movie/{movie_id}")
    public List<ReviewResponseDTO> getByMovie(@PathVariable("movie_id") Long id)
    {
        return service.getByMovie(id);
    }

}
