package com.digitalinnovationone.personapidio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalinnovationone.personapidio.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
