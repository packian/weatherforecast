package com.demo.weather.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class WeatherForecastService {

	@Autowired
	private WeatherForecastRepo weatherForecastRepo;

	public List<WeatherForecastSeries> fetchForecast(String locationName) {
		return weatherForecastRepo.findByLocationName(locationName);
	}

	@Cacheable("weatherdata")
	public List<WeatherForecastSeries> fetchForecastByDate(String locationName, String startDate, String endDate) {
		System.out.println("fetching forecast data");
		return weatherForecastRepo.findByLocationNameAndDate(locationName, startDate, endDate);
	}
}
