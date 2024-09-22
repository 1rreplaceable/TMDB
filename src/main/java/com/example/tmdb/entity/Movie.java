package com.example.tmdb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
@Getter // 필요 시 명시적으로 사용
@NoArgsConstructor // 기본 생성자
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter // 제목은 수정할 수 있으므로 setter 추가
    private String title;

    @Setter // 줄거리도 수정할 수 있도록 허용
    private String overview;

    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @Setter
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

    @ManyToMany
    @JoinTable(
            name = "movie_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres = new HashSet<>();

    // Actor와의 관계를 ManyToOne으로 변경
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private Set<Actor> actors = new HashSet<>();

    // Director와의 관계를 ManyToOne으로 변경
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private Set<Director> directors = new HashSet<>();

    // equals와 hashCode는 id 필드를 기준으로 구현
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id != null && id.equals(movie.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
