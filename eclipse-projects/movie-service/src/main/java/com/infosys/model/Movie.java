package com.infosys.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Movie {
	private String imdbID;
	@JsonProperty("Title")
	private String title;
	
	@JsonProperty("Year")
	private String year;
	
	@JsonProperty("Genre")
	private String genre;
	
	@JsonProperty("Runtime")
	private String runtime;
	
	@JsonProperty("Actors")
	private String actors;
	
	@JsonProperty("Director")
	private String director;
	
	private String imdbRating;
	private String imdbVotes;
}
