package com.movieDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


//@SpringBootApplication
@Configuration
@ComponentScan(basePackages = { "com.movieDB" })
@EnableAutoConfiguration
public class MovieDbApp {
	
	public static void main(String[] args) {
		SpringApplication.run(MovieDbApp.class, args);
	}

}
