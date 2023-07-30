package com.infosys.personsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.personsservice.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
