package com.example.tmdb.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "actors")
@Data
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String profilePath;

    @ManyToMany(mappedBy = "actors")
    @EqualsAndHashCode.Exclude
    private Set<Movie> movies = new HashSet<>();
}
