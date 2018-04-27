package com.starwars.starwarsapi.repository;

import com.starwars.starwarsapi.model.Film;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FilmRepositoryImpl implements CustomFilmRepository {

    @Override
    public void logFile(Film film) {
        log.info(film.toString());
    }
}
