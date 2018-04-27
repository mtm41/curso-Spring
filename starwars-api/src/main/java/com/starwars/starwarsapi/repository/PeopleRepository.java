package com.starwars.starwarsapi.repository;

import com.starwars.starwarsapi.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long>, JpaSpecificationExecutor {
    People findByNameIgnoreCase(String name);
    List<People> findByHeightGreaterThan(Integer height);
    List<People> findByEyeColorIn(Collection<String> eyeColors);
    List<People> findFirst20ByOrderByMassDesc();
    List<People> findByEyeColorInOrderByNameAsc(Collection<String> eyeColors);

    @Query(value = "SELECT * FROM People WHERE name LIKE 'S%'", nativeQuery = true)
    List<People> findByNameStartingWith(String name);
}
