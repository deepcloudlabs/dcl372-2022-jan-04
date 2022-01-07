package com.example.imdb.repository;

import java.util.List;

import com.example.imdb.entity.jpa.Genre;
import com.example.imdb.entity.jpa.Movie;


public interface ImdbRepository {
	List<Genre> getAllGenres();
	List<Movie> getAllByGenre(String genre);
	
}
