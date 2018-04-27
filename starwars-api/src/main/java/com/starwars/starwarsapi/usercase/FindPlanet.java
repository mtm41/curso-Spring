package com.starwars.starwarsapi.usercase;

import com.starwars.starwarsapi.model.Planet;
import com.starwars.starwarsapi.repository.PlanetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static org.springframework.util.Assert.notNull;

@Service
@AllArgsConstructor
public class FindPlanet {
    private final PlanetRepository planetRepository;

    public Planet execute(Long idPlanet) throws NullPointerException{
        notNull(idPlanet, "Planet id cannot be null");

        return planetRepository.findById(idPlanet).orElseThrow(NullPointerException::new);
    }
}
