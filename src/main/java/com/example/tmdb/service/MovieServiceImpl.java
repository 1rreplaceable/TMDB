package com.example.tmdb.service;

import com.example.tmdb.dto.MovieDetailDTO;
import com.example.tmdb.dto.MovieRecommendationDTO;
import com.example.tmdb.entity.Director;
import com.example.tmdb.entity.Genre;
import com.example.tmdb.entity.Movie;
import com.example.tmdb.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public MovieDetailDTO findMovieDetailById(Long id) {
        return movieRepository.findById(id).map(this::convertToMovieDetailDTO).orElse(null);
    }

    @Override
    public List<MovieRecommendationDTO> getRecommendedMovies(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElse(null);
        List<Long> genreIds = movie.getGenres().stream().map(Genre::getId).collect(Collectors.toList());
        List<Movie> recommendedMovies = movieRepository.findTop20ByGenres(genreIds, movieId);

        return recommendedMovies.stream().map(this::convertToMovieRecommendationDTO).collect(Collectors.toList());
    }

    private MovieDetailDTO convertToMovieDetailDTO(Movie movie) {
        MovieDetailDTO dto = new MovieDetailDTO();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setOverview(movie.getOverview());
        dto.setReleaseDate(movie.getReleaseDate());
        dto.setRuntime(movie.getRuntime());
        dto.setBudget(movie.getBudget());
        dto.setRevenue(movie.getRevenue());
        dto.setOriginalLanguage(movie.getOriginalLanguage());
        dto.setImdbId(movie.getImdbId());
        dto.setPosterPath(movie.getPosterPath());
        dto.setBackdropPath(movie.getBackdropPath());
        dto.setPopularity(movie.getPopularity());
        dto.setVideo(movie.getVideo());
        dto.setAdult(movie.getAdult());
        dto.setGenres(movie.getGenres().stream()
                .map(Genre::getName)
                .collect(Collectors.toList()));
        dto.setActors(movie.getActors().stream()
                .map(actor -> actor.getName() + " (" + actor.getProfilePath() + ")")
                .collect(Collectors.toList()));
        dto.setDirectors(movie.getDirectors().stream().map(Director::getName).collect(Collectors.toList()));
        return dto;
    }

    private MovieRecommendationDTO convertToMovieRecommendationDTO(Movie movie) {
        MovieRecommendationDTO dto = new MovieRecommendationDTO();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setBackdropPath(movie.getBackdropPath()); // 배경 이미지 경로
        dto.setPopularity(movie.getPopularity());     // 인기도
        return dto;
    }

}
