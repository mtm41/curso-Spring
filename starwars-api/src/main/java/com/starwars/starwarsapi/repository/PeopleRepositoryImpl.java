package com.starwars.starwarsapi.repository;

import com.starwars.starwarsapi.model.People;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.EntityManager;
import javax.persistence.PostLoad;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RequiredArgsConstructor
public class PeopleRepositoryImpl implements CustomPeopleRepository {

    /* ESTO ES LO QUE HACE allArgsConstructor
    public PeopleRepositoryImpl(EntityManager en){
        this.entityManager= en;
    }*/
    @Autowired
    private EntityManager entityManager;



    @Override
    public List<People> findByEyeColorAreRed() {
        return null;
    }

    @Override
    public List<People> findByEyeColorAreYellow() {
        return null;
    }

    @Override
    public List<People> findByEyeColorAreRed(String color) {
        return null;
    }
}
