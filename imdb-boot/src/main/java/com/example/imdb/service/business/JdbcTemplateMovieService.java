package com.example.imdb.service.business;

import java.sql.Statement;
import java.util.Collection;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.imdb.entity.Director;
import com.example.imdb.entity.Genre;
import com.example.imdb.entity.Movie;
import com.example.imdb.service.MovieService;
import com.example.imdb.viewmodel.CriteriaBean;

@Repository
@ConditionalOnProperty(name = "persistence.method", havingValue = "jdbc")
public class JdbcTemplateMovieService implements MovieService {
	private static final String SELECT_MOVIE_BY_ID = "SELECT MOVIEID,TITLE,YEAR,IMDB FROM MOVIES WHERE MOVIEID=?";
	private static final String SELECT_MOVIES_PAGINATION = "SELECT MOVIEID,TITLE,YEAR,IMDB FROM MOVIES";
	private static final String SELECT_MOVIES_BY_YEAR_BETWEEN = "SELECT MOVIEID,TITLE,YEAR,IMDB FROM MOVIES WHERE YEAR BETWEEN ? AND ?";
	private static final String INSERT_INTO_MOVIES = "INSERT INTO MOVIES(TITLE,YEAR,IMDB) VALUES(?,?,?)";
	private static final String UPDATE_MOVIE = "UPDATE MOVIES set TITLE=?,YEAR=?,IMDB=? where MOVIEID=?";
	private static final String DELETE_MOVIE_BY_MOVIEID = "DELETE FROM MOVIES where MOVIEID=?";
	private static final String SELECT_DIRECTORS = "SELECT DIRECTORID,NAME,IMDB FROM DIRECTORS";
	private static final String SELECT_GENRES = "SELECT GENREID, DESCRIPTION FROM GENRES";
	private static final String SELECT_GENRE_BY_NAME = "SELECT GENREID, DESCRIPTION FROM GENRES WHERE DESCRIPTION=?";
	private static final String SELECT_MOVIES_BY_GENRE ="""
			SELECT m.* FROM MOVIES m, GENRES g, MOVIEGENRES mg
			WHERE m.movieID = mg.movieID
			AND g.genreid = mg.genreid
			AND g.description = ?""";
	private static final String SELECT_MOVIES_BY_YEAR_BETWEEN_AND_GENRE ="""
			SELECT m.* FROM MOVIES m, GENRES g, MOVIEGENRES mg
			WHERE m.movieID = mg.movieID
			AND g.genreID = mg.genreID
			AND YEAR BETWEEN ? AND ?
			AND g.description = ?""";
	private static final String SELECT_MOVIES_BY_DIRECTOR ="""
			SELECT m.* FROM MOVIES m, DIRECTORS d, MOVIEDIRECTORS md
			WHERE m.movieID = md.movieID
			AND d.directorID = md.directorID
			AND d.directorID = ?""";
	private static final RowMapper<Genre> GENRE_MAPPER = (rs, rowNum) -> new Genre(rs.getInt("genreID"), rs.getString("description"));
	private static final RowMapper<Movie> MOVIE_MAPPER = (rs, rowNum) -> new Movie(rs.getInt("movieID"), rs.getString("title"),rs.getInt("year"),rs.getString("imdb"));
	private final Logger logger = LoggerFactory.getLogger(JdbcTemplateMovieService.class);
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplateMovieService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Movie findMovieById(int id) {
		return jdbcTemplate.queryForObject(SELECT_MOVIE_BY_ID, new BeanPropertyRowMapper<Movie>(Movie.class), id);
	}

	@Override
	public Collection<Movie> findAllMovies() {
		return jdbcTemplate.query(SELECT_MOVIES_PAGINATION, new BeanPropertyRowMapper<Movie>(Movie.class));
	}

	@Override
	public Collection<Movie> findAllMoviesByYearRange(int fromYear, int toYear) {
		return jdbcTemplate.query(SELECT_MOVIES_BY_YEAR_BETWEEN, new BeanPropertyRowMapper<Movie>(Movie.class),
				new Object[] { fromYear, toYear });
	}

	@Override
	public Collection<Movie> findAllMoviesByDirectorId(int directorId) {
		return jdbcTemplate.query(SELECT_MOVIES_BY_DIRECTOR, MOVIE_MAPPER,new Object[] {directorId});
	}

	@Override
	public Collection<Movie> findAllMoviesByYearRangeAndGenre(String genre, int fromYear, int toYear) {
		return jdbcTemplate.query(SELECT_MOVIES_BY_YEAR_BETWEEN_AND_GENRE, new BeanPropertyRowMapper<Movie>(Movie.class),
				new Object[] { fromYear, toYear,genre });
	}

	@Override
	public Collection<Movie> findAllMoviesByGenre(String genre) {
		return jdbcTemplate.query(SELECT_MOVIES_BY_GENRE, MOVIE_MAPPER,new Object[] {genre});
	}

	@Override
	public Collection<Movie> findAllMoviesByCriteria(CriteriaBean criteria) {
		return null;
	}

	@Override
	@Transactional
	public Movie addMovie(Movie movie) {
		try {
			var keyHolder = new GeneratedKeyHolder();
			var numOfInserted = jdbcTemplate.update(connection -> {
				var ps = connection.prepareStatement(INSERT_INTO_MOVIES, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, movie.getTitle());
				ps.setInt(2, movie.getYear());
				ps.setString(3, movie.getImdb());
				return ps;
			}, keyHolder);
			if (numOfInserted > 0) {
				movie.setId(keyHolder.getKey().intValue());
				return movie;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}		
		return null;
	}

	@Transactional
	public Movie update(Movie movie) {
		try {
			var numOfUpdated = jdbcTemplate.update(UPDATE_MOVIE, movie.getTitle(), movie.getYear(), movie.getImdb(),movie.getId());
			if (numOfUpdated > 0) {
				return movie;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Transactional
	public Movie removeById(Integer id) {
		try {
			var movie = findMovieById(id);
			if (Objects.nonNull(movie)) {
				var numOfUpdated = jdbcTemplate.update(DELETE_MOVIE_BY_MOVIEID, id);
				if (numOfUpdated > 0) {
					return movie;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public Movie remove(Movie movie) {
		return removeById(movie.getId());
	}
	
	@Override
	public Genre findGenreByName(String genre) {
		return jdbcTemplate.queryForObject(SELECT_GENRE_BY_NAME, GENRE_MAPPER,new Object[] {genre});
	}

	@Override
	public Collection<Genre> findAllGenres() {
		return jdbcTemplate.query(SELECT_GENRES,GENRE_MAPPER);
	}

	@Override
	public Collection<Director> findAllDirectors() {
		return jdbcTemplate.query(SELECT_DIRECTORS, new BeanPropertyRowMapper<Director>(Director.class));
	}

}
