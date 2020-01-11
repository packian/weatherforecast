package com.demo.weather.api;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "weather_forecast_timeseries")
public class WeatherForecastSeries {

	@Id
	@Column(name = "date_time_utc")
	private String dateTimeUTC;
	@Column(name = "location_type")
	private String locationType;
	@Column(name = "location_code")
	private int locationCode;
	@Column(name = "location_name")
	private String locationName;
	@Column(name = "wind_direction")
	private String windDirection;
	@Column(name = "wind_speed_kts")
	private double windSpeedKTS;

	@Column(name = "temperature_celsius")
	private double temperatureCelsius;
	@Column(name = "cloud_cover_percentage")
	private int cloudCoverPercent;
	@Column(name = "relative_humidity_percentage")
	private int relativeHumidityPercent;
	@Column(name = "icon")
	private String icon;
	@Column(name = "precipitation_chance_percentage")
	private int precipitationChancePercent;
	@Column(name = "pressure_hpa")
	private double pressureHPA;

	public String getDateTimeUTC() {

		DateTimeFormatter oldPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		boolean cachedDat = false;
		try {
			LocalDateTime.parse(dateTimeUTC, oldPattern);
		} catch (Exception e) {
			cachedDat = true;
		}

		if (!cachedDat) {
			DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

			Date date = null;
			try {
				date = utcFormat.parse(dateTimeUTC);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			DateFormat locationFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			locationFormat.setTimeZone(TimeZone.getTimeZone("Australia/" + this.getLocationName()));

			this.dateTimeUTC = locationFormat.format(date);

		}
		return dateTimeUTC;
	}

	public void setDateTimeUTC(String dateTimeUTC) {
		this.dateTimeUTC = dateTimeUTC;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public int getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(int locationCode) {
		this.locationCode = locationCode;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	public double getWindSpeedKTS() {
		return windSpeedKTS;
	}

	public void setWindSpeedKTS(double windSpeedKTS) {
		this.windSpeedKTS = windSpeedKTS;
	}

	public double getTemperatureCelsius() {
		return temperatureCelsius;
	}

	public void setTemperatureCelsius(double temperatureCelsius) {
		this.temperatureCelsius = temperatureCelsius;
	}

	public int getCloudCoverPercent() {
		return cloudCoverPercent;
	}

	public void setCloudCoverPercent(int cloudCoverPercent) {
		cloudCoverPercent = cloudCoverPercent;
	}

	public int getRelativeHumidityPercent() {
		return relativeHumidityPercent;
	}

	public void setRelativeHumidityPercent(int relativeHumidityPercent) {
		this.relativeHumidityPercent = relativeHumidityPercent;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getPrecipitationChancePercent() {
		return precipitationChancePercent;
	}

	public void setPrecipitationChancePercent(int precipitationChancePercent) {
		this.precipitationChancePercent = precipitationChancePercent;
	}

	public double getPressureHPA() {
		return pressureHPA;
	}

	public void setPressureHPA(double pressureHPA) {
		this.pressureHPA = pressureHPA;
	}

	@Override
	public String toString() {
		return "WeatherForecastSeries [dateTimeUTC=" + dateTimeUTC + ", locationType=" + locationType
				+ ", locationCode=" + locationCode + ", locationName=" + locationName + ", windDirection="
				+ windDirection + ", windSpeedKTS=" + windSpeedKTS + ", temperatureCelsius=" + temperatureCelsius
				+ ", CloudCoverPercent=" + cloudCoverPercent + ", relativeHumidityPercent=" + relativeHumidityPercent
				+ ", icon=" + icon + ", precipitationChancePercent=" + precipitationChancePercent + ", pressureHPA="
				+ pressureHPA + "]";
	}

}
