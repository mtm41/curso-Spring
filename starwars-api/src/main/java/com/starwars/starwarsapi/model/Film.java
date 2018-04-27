package com.starwars.starwarsapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"people", "planets"})
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long filmId;

    @CreatedDate
    private LocalDateTime created;
    @LastModifiedDate
    private LocalDateTime edited;

    private String title;
    private Integer episodeId;
    @Column(length = 500)
    private String openingCrawl;
    private String director;
    private String producer;
    private Date releaseDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(joinColumns = {@JoinColumn(name = "film_id")},
        inverseJoinColumns = {@JoinColumn(name = "people_id")})
    private List<People> people;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(joinColumns = {@JoinColumn(name = "film_id")},
            inverseJoinColumns = {@JoinColumn(name = "planet_id")})
    private List<Planet> planets;
}
