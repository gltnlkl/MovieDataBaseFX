package com.gulukal.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "movies")
public class MovieEntity {
	
	
	@Id
	private long id;
	private String name;
	private int year;
	
	

}
