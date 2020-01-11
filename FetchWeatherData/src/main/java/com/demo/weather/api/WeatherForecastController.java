package com.demo.weather.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherForecastController {

	@Autowired
	WeatherForecastService weatherForecastService;

	@CrossOrigin
	@RequestMapping(value = "/fetchWeatherForecast/{location}", method = RequestMethod.GET)
	public List<WeatherForecastSeries> fetchWeatherForecast(@PathVariable("location") String location) {
		return weatherForecastService.fetchForecast(location);
	}

	@CrossOrigin
	@RequestMapping(value = "/fetchWeatherForecast/{location}/{startDate}/{endDate}", method = RequestMethod.GET)
	public List<WeatherForecastSeries> fetchWeatherForecastByDate(@PathVariable("location") String location,
			@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate) {

		return weatherForecastService.fetchForecastByDate(location, DateUtil.getDbFormat(startDate),
				DateUtil.getDbFormat(endDate));
	}
}
