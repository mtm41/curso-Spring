package com.starwars.starwarsapi.repository;

import com.starwars.starwarsapi.model.Film;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "starwars")
public interface CustomFilmRepository {
    void logFile(Film film);
}
