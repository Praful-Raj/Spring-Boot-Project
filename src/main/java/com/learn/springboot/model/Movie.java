package com.learn.springboot.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import javax.persistence.Id;
import lombok.RequiredArgsConstructor;

@Data //combination of Getter and Setter
@NoArgsConstructor //default constructor
@AllArgsConstructor //all attribute parameter constructor
//@RequiredArgsConstructor //create a constructor only with @NonNull Attribures 
@Builder //another method to create object
@Entity //JPA will create the table inside the database
public class Movie {
	
	@Id
	private int id;
	private String name;
	private String director;
	private float length;
	private String producer;

}
