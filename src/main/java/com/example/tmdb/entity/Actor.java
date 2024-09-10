package com.example.tmdb.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String profilePath;

    @ManyToMany(mappedBy = "actors")
    private Set<Movie> movies = new HashSet<>();
}
