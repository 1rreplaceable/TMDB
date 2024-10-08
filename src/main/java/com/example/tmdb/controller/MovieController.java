package com.example.tmdb.controller;

import com.example.tmdb.dto.MovieDetailDTO;
import com.example.tmdb.dto.MovieRecommendationDTO;
import com.example.tmdb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDetailDTO> getMovieById(@PathVariable Long id) {
        MovieDetailDTO movieDetail = movieService.findMovieDetailById(id);
        if (movieDetail != null) {
            return ResponseEntity.ok(movieDetail);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/recommendations")
    public ResponseEntity<List<MovieRecommendationDTO>> getRecommendedMovies(@PathVariable("id") Long id) {
        List<MovieRecommendationDTO> recommendedMovies = movieService.getRecommendedMovies(id);
        return ResponseEntity.ok(recommendedMovies);
    }
}
