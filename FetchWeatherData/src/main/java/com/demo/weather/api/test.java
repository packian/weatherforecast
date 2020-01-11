package com.demo.weather.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class test {

	public static void main(String[] args) {
		
		String input = "2017-01-18 20:10:00";
		
		DateTimeFormatter oldPattern = DateTimeFormatter
		        .ofPattern("yyyy-MM-dd HH:mm:ss");
	    LocalDateTime datetime = LocalDateTime.parse(input, oldPattern);
		   
		   
		
	}

}
