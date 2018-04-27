package com.starwars.starwarsapi.repository;

import com.starwars.starwarsapi.model.People;
import org.springframework.data.jpa.domain.Specification;
import java.util.List;

import static org.springframework.data.jpa.domain.Specification.where;

public class PeopleSpecifications {
    public static Specification<People> hasRedEyes() {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("eyeColor"), "red");
    }
}
