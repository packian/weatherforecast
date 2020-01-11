package com.demo.weather.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FetchWeatherDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(FetchWeatherDataApplication.class, args);
	}

}
