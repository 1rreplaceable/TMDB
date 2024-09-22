package com.example.tmdb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "directors")
@Getter
@Setter
@NoArgsConstructor // 기본 생성자
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // 영화와 Director는 ManyToOne 관계
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    // equals와 hashCode는 id 필드를 기준으로 구현
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return id != null && id.equals(director.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
