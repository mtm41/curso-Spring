package com.starwars.starwarsapi.usercase;

import com.starwars.starwarsapi.model.Planet;
import com.starwars.starwarsapi.repository.PlanetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FindAllPlanets {
    private final PlanetRepository planetRepository;

    public List<Planet> execute() {
        return planetRepository.findAll();
    }
}
