package com.example.imdb.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.imdb.entity.Genre;
import com.example.imdb.entity.Movie;
import com.example.imdb.repository.ImdbRepository;

@RestController
@RequestScope
// http(s)://localhost:8100/imdb/api/v1/movies
@CrossOrigin("*")
public class ImdbRestController {
	private ImdbRepository imdbRepository;

	public ImdbRestController(ImdbRepository imdbRepository) {
		this.imdbRepository = imdbRepository;
	}

	// GET http://localhost:8100/imdb/api/v1/genres
	@GetMapping(value = "/genres")
	public Collection<Genre> getAllGenres() {
		return imdbRepository.getAllGenres()
				  .stream()
				  .map(genre -> new Genre(genre.getId(), genre.getDescription()))
				  .toList();
	}

	// GET http://localhost:8100/imdb/api/v1/movies?genre=Drama
	@GetMapping("movies")
	public Collection<Movie> getMoviesByGenre(@RequestParam String genre) {
		return imdbRepository.getAllByGenre(genre)
				.stream()
				.map(movie -> new Movie(movie.getId(), 
						                movie.getTitle(), 
						                movie.getYear(), 
						                movie.getImdb()))
				.toList();
	}
	
}
