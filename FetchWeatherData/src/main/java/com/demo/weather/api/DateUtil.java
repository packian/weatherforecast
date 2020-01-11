package com.demo.weather.api;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String getDbFormat(String recDate) {
		DateFormat recFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = recFormat.parse(recDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		DateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dbFormat.format(date);
	}
}
