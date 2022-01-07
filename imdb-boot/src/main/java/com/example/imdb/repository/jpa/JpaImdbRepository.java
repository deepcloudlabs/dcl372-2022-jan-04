package com.example.imdb.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.example.imdb.entity.jpa.Genre;
import com.example.imdb.entity.jpa.Movie;
import com.example.imdb.repository.ImdbRepository;

@Repository
public class JpaImdbRepository implements ImdbRepository {
	private EntityManager entityManager;
	
	public JpaImdbRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Genre> getAllGenres() {
		return entityManager.createNamedQuery("Genre.findAll", Genre.class)
				   .getResultList();
	}

	@Override
	public List<Movie> getAllByGenre(String description) {
		return entityManager.createNamedQuery("Movie.findByGenre", Movie.class)
				            .setParameter("description", description)
				            .getResultList();
	}

}
