package com.gulukal.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class Link {
	
	
	private long id;
	private String imdb;
	private String tmdb;

}
