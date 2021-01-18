package com.cognizant.truyum.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {

	/**
	 * static method to convert the input String in "dd/MM/yyyy" format into
	 * java.util.Date type
	 * 
	 * @param date
	 * @return
	 */
	public static Date convertToDate(String date) {
		Date inputDate = null;
		try {
			inputDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
			return inputDate;
		} catch (ParseException e) {
			return inputDate;
		}
	}
}
