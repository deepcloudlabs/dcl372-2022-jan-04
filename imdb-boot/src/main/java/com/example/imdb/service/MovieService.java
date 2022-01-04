package com.example.imdb.service;
import java.util.Collection;

import com.example.imdb.entity.Director;
import com.example.imdb.entity.Genre;
import com.example.imdb.entity.Movie;
import com.example.imdb.viewmodel.CriteriaBean;

/**
 * 
 * @author Binnur Kurt
 *
 */
public interface MovieService {
	Movie findMovieById(int id);

	Collection<Movie> findAllMovies();

	Collection<Movie> findAllMoviesByYearRange(int fromYear, int toYear);

	Collection<Movie> findAllMoviesByDirectorId(int directorId);

	Collection<Movie> findAllMoviesByYearRangeAndGenre(String genre,
			int fromYear, int toYear);

	Collection<Movie> findAllMoviesByGenre(String genre);

	Collection<Movie> findAllMoviesByCriteria(CriteriaBean criteria);

	Movie addMovie(Movie movie);

	Genre findGenreByName(String genre);

	Collection<Genre> findAllGenres();

	Collection<Director> findAllDirectors();
}
