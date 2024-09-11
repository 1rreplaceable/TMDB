package com.example.tmdb.repository;

import com.example.tmdb.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "SELECT DISTINCT m.* FROM movies m " +
            "JOIN movie_genres mg ON m.id = mg.movie_id " +
            "WHERE mg.genre_id IN :genreIds AND m.id <> :movieId " +
            "ORDER BY m.popularity DESC " +
            "LIMIT 20", nativeQuery = true)
    List<Movie> findTop20ByGenres(List<Long> genreIds, @Param("movieId") Long movieId);
}
