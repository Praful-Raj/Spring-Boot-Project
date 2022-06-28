package com.learn.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.learn.springboot.model.Movie;
import com.learn.springboot.repository.MovieRepository;
import com.learn.springboot.service.MovieService;
import com.learn.springboot.service.MovieService;

@SpringBootApplication
public class SpringFirstProjectApplication implements CommandLineRunner {

	@Autowired
	MovieService movieService;
	
	@Autowired 
	EntityManager entityManager;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringFirstProjectApplication.class, args);
	
		System.out.println("helo");
		
	}
	@Override
	public void run(String... args) throws Exception{
		List<Movie> movies = movieService.getAllMovies();
		for(Movie temp : movies)
		{
			System.out.println("------------------------");
			System.out.println("Id             : " + temp.getId());
			System.out.println("Movie Name     : " + temp.getName());
			System.out.println("Movie Director : " + temp.getDirector());
			System.out.println("Movie Duration : " + temp.getLength()+" hrs");
			System.out.println("Movie Producer : " + temp.getProducer());
			System.out.println("------------------------");
		}
	}

}
