package com.example.imdb.entity.jpa;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// Mapping -> Convention over Configuration
//            Configuration by exception 
@Entity
@Table(name="movies")
@NamedQueries({
	@NamedQuery(name="Movie.findByGenre", 
			query = """
					select m from Movie m JOIN m.genres g 
                    where g.description = :description
                    """)
})
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="movieID")
	private int id;
	private String title;
	private int year;
	@Column(unique = true)
	private String imdb;
	
	@OneToMany
	@JoinTable(
		name="moviegenres",
		joinColumns = {
			@JoinColumn(name="movieid",referencedColumnName = "movieid", nullable = false)
		},
		inverseJoinColumns = {
			@JoinColumn(name="genreid",referencedColumnName = "genreid", nullable = false)				
		}
	)
	private List<Genre> genres;
	
	@OneToMany
	@JoinTable(
			name="moviedirectors",
			joinColumns = {
					@JoinColumn(name="movieid",referencedColumnName = "movieid", nullable = false)
			},
			inverseJoinColumns = {
					@JoinColumn(name="directorid",referencedColumnName = "directorid", nullable = false)				
			}
			)
	private List<Director> directors;

	public Movie() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public List<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", imdb=" + imdb + "]";
	}
	
}
