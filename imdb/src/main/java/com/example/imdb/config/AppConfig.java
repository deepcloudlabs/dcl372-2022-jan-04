package com.example.imdb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
	"com.example.imdb.service.business"	
})
public class AppConfig {

}
