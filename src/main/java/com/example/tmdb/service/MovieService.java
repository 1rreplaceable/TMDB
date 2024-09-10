package com.example.tmdb.service;

import com.example.tmdb.dto.MovieDetailDTO;

public interface MovieService {
    MovieDetailDTO findMovieDetailById(Long id);
}
