package com.learn.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.springboot.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
