package jmaster.io.jpatutorial.repostirory;

import org.springframework.data.jpa.repository.JpaRepository;

import jmaster.io.jpatutorial.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
