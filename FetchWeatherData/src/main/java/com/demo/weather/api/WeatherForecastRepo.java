package com.demo.weather.api;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherForecastRepo extends CrudRepository<WeatherForecastSeries, String> {

	List<WeatherForecastSeries> findByLocationName(String locationName);

	@Query("SELECT forecast FROM WeatherForecastSeries forecast WHERE forecast.locationName = :locationName and forecast.dateTimeUTC >= :startDate and forecast.dateTimeUTC <= :endDate")
	List<WeatherForecastSeries> findByLocationNameAndDate(@Param("locationName") String locationName,
			@Param("startDate") String startDate, @Param("endDate") String endDate);
}
