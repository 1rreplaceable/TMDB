-- 외래 키 제약 조건을 일시적으로 비활성화
SET FOREIGN_KEY_CHECKS = 0;

-- 기존 데이터 삭제 및 AUTO_INCREMENT 초기화
TRUNCATE TABLE movie_directors;
TRUNCATE TABLE movie_actors;
TRUNCATE TABLE directors;
TRUNCATE TABLE actors;
TRUNCATE TABLE movies;
TRUNCATE TABLE genres;

-- 외래 키 제약 조건 다시 활성화
SET FOREIGN_KEY_CHECKS = 1;

-- Genres
INSERT INTO genres (name) VALUES
    ('Action'),
    ('Drama'),
    ('Comedy'),
    ('Thriller');

-- Movies
INSERT INTO movies (title, overview, release_date, runtime, budget, revenue, original_language, imdb_id, poster_path, backdrop_path, popularity, video, adult)
VALUES
    ('Inception', 'A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO.', '2010-07-16', 148, 160000000, 825532764, 'en', 'tt1375666', '/9gk7adHYeDvHkCSEqAvQNLV5Uge.jpg', '/s2bT29y0ngXxxu2IA8AOzzXTRhd.jpg', 82.0, false, false),
    ('The Shawshank Redemption', 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.', '1994-09-23', 142, 25000000, 28341469, 'en', 'tt0111161', '/q6y0Go1tsGEsmtFryDOJo3dEmqu.jpg', '/iNh3BivHyg5sQRPP1KOkzguEX0H.jpg', 95.5, false, false),
    ('The Godfather', 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.', '1972-03-14', 175, 6000000, 245066411, 'en', 'tt0068646', '/3bhkrj58Vtu7enYsRolD1fZdja1.jpg', '/rSPw7tgCH9c6NqICZef4kZjFOQ5.jpg', 87.0, false, false),
    ('Pulp Fiction', 'The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.', '1994-10-14', 154, 8000000, 213928762, 'en', 'tt0110912', '/d5iIlFn5s0ImszYzBPb8JPIfbXD.jpg', '/4cDFJr4HnXN5AdPw4AKrmLlMWdO.jpg', 88.3, false, false);

-- Actors
INSERT INTO actors (name, profile_path) VALUES
    ('Leonardo DiCaprio', '/wo2hJpn04vbtmh0B9utCFdsQhxM.jpg'),
    ('Morgan Freeman', '/oGJQhOpT8S1M56tvSsbEBePV5O1.jpg'),
    ('Al Pacino', '/eLAWpp5BLbTwjj35MbGzpL0QkZQ.jpg'),
    ('John Travolta', '/fRruamtwPzQ3HSF0bHjEN2wveEJ.jpg');

-- Movie_Actors
INSERT INTO movie_actors (movie_id, actor_id) VALUES
    (1, 1), -- Inception, Leonardo DiCaprio
    (2, 2), -- The Shawshank Redemption, Morgan Freeman
    (3, 3), -- The Godfather, Al Pacino
    (4, 4); -- Pulp Fiction, John Travolta

-- Directors
INSERT INTO directors (name) VALUES
    ('Christopher Nolan'),
    ('Frank Darabont'),
    ('Francis Ford Coppola'),
    ('Quentin Tarantino');

-- Movie_Directors
INSERT INTO movie_directors (movie_id, director_id) VALUES
    (1, 1), -- Inception, Christopher Nolan
    (2, 2), -- The Shawshank Redemption, Frank Darabont
    (3, 3), -- The Godfather, Francis Ford Coppola
    (4, 4); -- Pulp Fiction, Quentin Tarantino