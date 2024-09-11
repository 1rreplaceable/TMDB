package com.example.tmdb.dto;

import lombok.Data;

@Data
public class MovieRecommendationDTO {
    private Long id;
    private String title;
    private String backdropPath;
    private Double popularity;
}
