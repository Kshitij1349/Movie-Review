package com.kshitu.MovieRating.service;

import com.kshitu.MovieRating.repository.MovieRepo;
import com.kshitu.MovieRating.repository.ReviewRepo;
import com.kshitu.MovieRating.repository.UserRepo;
import com.kshitu.MovieRating.dto.ReviewRequestDTO;
import com.kshitu.MovieRating.dto.ReviewResponseDTO;
import com.kshitu.MovieRating.model.movies;
import com.kshitu.MovieRating.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kshitu.MovieRating.model.review;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewRepo review_repo;
    @Autowired
    UserRepo user_repo;
    @Autowired
    MovieRepo movie_repo;


    public ReviewResponseDTO addReview(ReviewRequestDTO json) {

        review review = new review();

        user u = user_repo.findById(json.user_id()).orElseThrow(() -> new RuntimeException("User not found"));
        movies m = movie_repo.findById(json.movie_id()).orElseThrow(() -> new RuntimeException("Movie not found"));

        review.setReviewer_name(u);
        review.setMovie(m);
        review.setContent(json.content());
        review.setRating(json.rating());

        review_repo.save(review);

        ReviewResponseDTO DTO= new ReviewResponseDTO(
                review.getId(),
                review.getMovie().getName(),
                review.getReviewer_name().getName(),
                review.getRating(),
                review.getContent()
        );

        return DTO;
    }


    public List<ReviewResponseDTO> getAllReview() {

        List<ReviewResponseDTO> DTO=new ArrayList<>();

        for(review review : review_repo.findAll())
        {
            ReviewResponseDTO obj = new ReviewResponseDTO(
                    review.getId(),
                    review.getMovie().getName(),
                    review.getReviewer_name().getName(),
                    review.getRating(),
                    review.getContent()
            );
            DTO.add(obj);
        }
        return DTO;
    }

    public ReviewResponseDTO updateReview(Long id, ReviewRequestDTO json) {
        review review=review_repo.findById(id).orElseThrow(() -> new RuntimeException("Review not found for updating"));

        review.setContent(json.content());
        review.setRating(json.rating());

        ReviewResponseDTO DTO=new ReviewResponseDTO(
                review.getId(),
                review.getMovie().getName(),
                review.getReviewer_name().getName(),
                review.getRating(),
                review.getContent()
        );

        review_repo.save(review);
        return DTO;
    }

    public ReviewResponseDTO deleteReview(Long id) {

        review review=review_repo.findById(id).orElseThrow(()-> new RuntimeException("Review not found for deleting it"));
        ReviewResponseDTO DTO=new ReviewResponseDTO(
                review.getId(),
                review.getMovie().getName(),
                review.getReviewer_name().getName(),
                review.getRating(),
                review.getContent()
        );
        review_repo.deleteById(id);

        return DTO;
    }

    public List<ReviewResponseDTO> getByMovie(Long id) {

        List<ReviewResponseDTO> DTO=new ArrayList<>();

        for(review r: review_repo.findByMovieId(id)) {
            ReviewResponseDTO obj = new ReviewResponseDTO(
                    r.getId(),
                    r.getMovie().getName(),
                    r.getReviewer_name().getName(),
                    r.getRating(),
                    r.getContent()
            );
            DTO.add(obj);
        }
        return DTO;
    }
}
