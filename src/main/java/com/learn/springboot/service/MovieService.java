package com.learn.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.springboot.model.Movie;
import com.learn.springboot.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired //creating a new object
	MovieRepository repository;
	
	public List<Movie> getAllMovies() {
		return repository.findAll(); //select * from movie -> List<Movie>
	}
	
	public void addMovie(Movie movie)
	{
		repository.save(movie);
	}
	
	public void deleteMovie(Movie movie) {
		repository.delete(movie);
	}
}
