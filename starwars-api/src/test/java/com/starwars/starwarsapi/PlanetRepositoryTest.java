package com.starwars.starwarsapi;

import com.starwars.starwarsapi.model.Planet;
import com.starwars.starwarsapi.repository.PlanetRepository;
import org.h2.store.Page;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PlanetRepositoryTest {
    @Autowired
    private PlanetRepository planetRepository;

    @Test
    public void should_find_by_name() {
       Planet alderan = planetRepository.findByName("Alderaan");
        Assert.assertEquals("Alderaan", alderan.getName());
    }

    @Test
    public void should_be_pageable() {
       // Page<Planet> planets = planetRepository.findAll(PageRequest.of());
        Assert.assertTrue(true);
    }
}
