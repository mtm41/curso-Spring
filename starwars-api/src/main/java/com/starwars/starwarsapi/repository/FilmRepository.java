package com.starwars.starwarsapi.repository;

import com.starwars.starwarsapi.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findAllByReleaseDateGreaterThanEqual(Date releaseDate);

    @Query("SELECT f FROM Film f WHERE f.people.size = (SELECT max(f2.people.size) FROM Film f2)")
    List<Film> findAllByMaxPeople();

    @Query("SELECT f FROM Film f WHERE f.people.size = (SELECT min(f2.people.size) FROM Film f2)")
    List<Film> findAllByMinPlanets();

    @Query("SELECT f FROM Film f JOIN f.people p WHERE p.name=:name")
    List<Film> findAllByPeopleContains(@Param("name") String name);
}
