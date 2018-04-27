package com.starwars.starwarsapi.repository;

import com.starwars.starwarsapi.model.People;

import java.util.List;

public interface CustomPeopleRepository {
    List<People> findByEyeColorAreRed();
    List<People> findByEyeColorAreYellow();
    List<People> findByEyeColorAreRed(String color);
}
