package com.learn.springboot.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.learn.springboot.model.Movie;
import com.learn.springboot.service.MovieService;
import java.util.List;

@Controller
public class MovieController {
	@Autowired
	MovieService movieService;
	
	@GetMapping("/getmovie")
	@ResponseBody
	public Movie getMovie() {
		return Movie.builder().director("SLB").length(2).name("Padamavat").producer("Sanjay Leela Bhanshali").build();
	}
	
	@GetMapping("/")
	public String listOfMovie(ModelMap map)
	{
		List<Movie> movies = movieService.getAllMovies();
		map.addAttribute("message", movies);
		return "list";
	}
	
	@GetMapping("/addmovie")
	public String addNewMovie(@RequestParam int id, @RequestParam String name, @RequestParam String director,
			@RequestParam float length, @RequestParam String producer, ModelMap model)
	{
		Movie movie= Movie.builder().id(id).name(name).director(director).length(length).producer(producer).build();
		movieService.addMovie(movie);
		List<Movie> movies = movieService.getAllMovies();
		model.addAttribute("message",movies);
		return "list";
	}
	@GetMapping("/delete")
	public String deleteMovie(@RequestParam int id, ModelMap model)
	{
		movieService.deleteMovie(Movie.builder().id(id).build());
		List<Movie> movies = movieService.getAllMovies();
		model.addAttribute("message",movies);
		return "list";
		
	}
	
}
