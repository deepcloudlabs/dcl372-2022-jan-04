package com.example.imdb.service.business;

import java.util.Collection;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import com.example.imdb.entity.Director;
import com.example.imdb.entity.Genre;
import com.example.imdb.entity.Movie;
import com.example.imdb.service.MovieService;
import com.example.imdb.viewmodel.CriteriaBean;

@Repository
@ConditionalOnProperty(name = "persistence.method", havingValue = "jdbc")
public class JdbcTemplateMovieService implements MovieService {

	@Override
	public Movie findMovieById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Movie> findAllMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Movie> findAllMoviesByYearRange(int fromYear, int toYear) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Movie> findAllMoviesByDirectorId(int directorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Movie> findAllMoviesByYearRangeAndGenre(String genre, int fromYear, int toYear) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Movie> findAllMoviesByGenre(String genre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Movie> findAllMoviesByCriteria(CriteriaBean criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Genre findGenreByName(String genre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Genre> findAllGenres() {
		return List.of(new Genre(1, "elma"));
	}

	@Override
	public Collection<Director> findAllDirectors() {
		// TODO Auto-generated method stub
		return null;
	}

}
