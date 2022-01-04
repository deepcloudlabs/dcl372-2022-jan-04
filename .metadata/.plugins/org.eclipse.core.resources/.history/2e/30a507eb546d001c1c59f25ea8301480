package com.example.imdb;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.imdb.config.AppConfig;
import com.example.imdb.service.MovieService;

public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext container =
			new AnnotationConfigApplicationContext(AppConfig.class);
		var movieSrv = 
				container.getBean(MovieService.class);
		movieSrv.findAllMoviesByYearRangeAndGenre(
				"Drama", 1970, 1979)
		        .forEach(System.out::println);
		container.close();
	}
}
