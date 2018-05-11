package com.starwars.starwarsbatch.repository;

import com.starwars.starwarsbatch.model.people;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<people, people> {
}
