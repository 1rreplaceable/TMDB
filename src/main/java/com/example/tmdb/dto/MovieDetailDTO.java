package com.example.tmdb.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MovieDetailDTO {
    private Long id;
    private String title;
    private String overview;
    private Date releaseDate;
    private Integer runtime;
    private Long budget;
    private Long revenue;
    private String originalLanguage;
    private String imdbId;
    private String posterPath;
    private String backdropPath;
    private Double popularity;
    private Boolean video;
    private Boolean adult;
    private List<String> genres;
    private List<String> actors;
    private List<String> directors;
}
