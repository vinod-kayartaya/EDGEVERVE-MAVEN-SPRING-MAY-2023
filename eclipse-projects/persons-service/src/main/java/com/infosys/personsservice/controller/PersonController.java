package com.infosys.personsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.personsservice.entity.Person;
import com.infosys.personsservice.repository.PersonRepository;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

	@Autowired
	private PersonRepository repo;
	
	@GetMapping
	public List<Person> handleGetAll(){
		return repo.findAll();
	}
}
