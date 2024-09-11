package com.example.tmdb.service;

import com.example.tmdb.dto.MovieDetailDTO;
import com.example.tmdb.dto.MovieRecommendationDTO;

import java.util.List;

public interface MovieService {
    MovieDetailDTO findMovieDetailById(Long id);

    List<MovieRecommendationDTO> getRecommendedMovies(Long movieId);
}
