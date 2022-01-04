package com.example.lottery;

import java.util.stream.Collectors;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.lottery.config.AppConfig;
import com.example.lottery.service.LotteryService;

public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext container =
				new AnnotationConfigApplicationContext(AppConfig.class);
		var numbers =
			container.getBean(LotteryService.class)
		         .draw(60, 6)
		         .stream()
		         .map(i -> i.toString())
		         .collect(Collectors.joining(",", "[", "]"));
		 System.err.println(numbers); 
		 container.close();
	}
}
