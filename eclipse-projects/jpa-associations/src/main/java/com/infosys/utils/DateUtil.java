package com.infosys.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.SneakyThrows;

public final class DateUtil {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private DateUtil() {
	}

	@SneakyThrows
	public static Date toDate(String input) {
		return input==null? null: sdf.parse(input);
	}

	public static String toString(Date input) {
		return input==null? null: sdf.format(input);
	}
}
