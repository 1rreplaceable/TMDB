CREATE DATABASE IF NOT EXISTS tmdb;
USE tmdb;

CREATE TABLE IF NOT EXISTS movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    overview TEXT,
    release_date DATE,
    runtime INT,
    budget BIGINT,
    revenue BIGINT,
    original_language VARCHAR(50),
    imdb_id VARCHAR(50),
    poster_path VARCHAR(255),
    backdrop_path VARCHAR(255),
    popularity DECIMAL(10, 2),
    video BOOLEAN,
    adult BOOLEAN
);

CREATE TABLE IF NOT EXISTS genres (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS movie_genres (
    movie_id INT,
    genre_id INT,
    FOREIGN KEY (movie_id) REFERENCES movies(id),
    FOREIGN KEY (genre_id) REFERENCES genres(id),
    PRIMARY KEY (movie_id, genre_id)
);

CREATE TABLE IF NOT EXISTS actors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    profile_path VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS movie_actors (
    movie_id INT,
    actor_id INT,
    FOREIGN KEY (movie_id) REFERENCES movies(id),
    FOREIGN KEY (actor_id) REFERENCES actors(id),
    PRIMARY KEY (movie_id, actor_id)
);

CREATE TABLE IF NOT EXISTS directors (
     id INT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS movie_directors (
     movie_id INT,
     director_id INT,
     FOREIGN KEY (movie_id) REFERENCES movies(id),
    FOREIGN KEY (director_id) REFERENCES directors(id),
    PRIMARY KEY (movie_id, director_id)
);
