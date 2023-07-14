package com.infosys.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infosys.model.Movie;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

	@Autowired
	private RestTemplate template;

	@GetMapping(path = "/{imdbID}", produces = "application/json")
	public ResponseEntity<?> handleGetOne(@PathVariable String imdbID) {

		try {
			Movie m = template.getForObject("https://www.omdbapi.com/?apikey=aa9e49f&i=" + imdbID, Movie.class);
			return ResponseEntity.ok(m);
		} catch (Exception e) {
			Map<String, Object> err = new HashMap<>();
			err.put("message", e.getMessage());
			return ResponseEntity.status(404).body(err);
		}
	}

}
